package com.example.certi.veri.controller;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.certi.veri.entity.Certificate;
import com.example.certi.veri.entity.Transaction;
import com.example.certi.veri.entity.Verification;
import com.example.certi.veri.repository.TransactionRepository;
import com.example.certi.veri.services.TransactionServiceImple;
import com.example.certi.veri.services.VerificationServiceImple;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/api/verification")
public class VerificationController {

	@Autowired
	private VerificationServiceImple vserv;
	
	@Autowired
	private TransactionServiceImple tserv;
	
	@Autowired
	private TransactionRepository trep;
	
	
	@PostMapping("/initiate-verification")
	public ResponseEntity<?> initiateVerification(@RequestParam String id, @RequestParam String studentName, @RequestParam int prn ) throws RazorpayException{
		
		
		//Checking if certificate details are matching or not
		Certificate certi = vserv.verifyCertificate(id, studentName, prn);
		if(certi == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certificate not found or the details do not match");
		}
		
		//creating payment order
		float amount = 100.0f;
		String currency = "INR";
		String receipt = "receipt_"+id;
		
		String orderId = tserv.createOrder(amount, currency, receipt);
	
		//saving the transaction details
		Transaction tran = new Transaction();
		
		tran.setAmount(amount);
		tran.setDescription("Certificate verification fee");
		tran.setTransactionDate(new Date());
		tran.setTransactionType("Payment");
		tran.setVerification(certi.getVerification().get(0));
		
		trep.save(tran);
	
		//returning the order id and razorpay key to the front-end
		JSONObject res = new JSONObject();
		JSONObject response = new JSONObject();
        response.put("orderId", orderId);
        response.put("razorpayKey", tserv.getRazorpayKeyId());
        response.put("amount", amount);
        response.put("currency", currency);
        
        return ResponseEntity.ok(res.toString());

	}
	
	
	@PostMapping("/complete-verification")
	public ResponseEntity<?> completeVerification(@RequestParam String paymentId, @RequestParam String orderId) throws RazorpayException{
		
		//verifying the payment
		boolean isPaymentSuccessful = tserv.verifyPayment(paymentId, orderId);
		if(!isPaymentSuccessful) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment verification failed");
			
		}
		
		//Updating the transaction status
		Transaction transaction = trep.findByOrderId(orderId);
		transaction.setTransactionType("PAID");
		trep.save(transaction);
		
		//Mark the verification as completed
		Verification veri = transaction.getVerification();
		veri.setStatus("Verified");
		veri.setVerifiedDate(new Date());
		vserv.addVerification(veri);
		
		return ResponseEntity.ok("Certificate Verified Successfully");
		
	}
	
}
