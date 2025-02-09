package com.example.certi.veri.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.certi.veri.repository.TransactionRepository;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class TransactionServiceImple implements TransactionService{

	@Autowired
	TransactionRepository trep;
	
	@Value("${razorpay.key.id}")
	private String razorpayKeyId;
	
	@Value("${razorpay.key.secret}")
	private String razorpayKeySecret;
	
	@Override
	public String createOrder(float amount, String currency, String receipt) throws RazorpayException {
	
			RazorpayClient razorCli = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
			JSONObject orderReq = new JSONObject();
			orderReq.put("amount", amount*100);
			orderReq.put("currency", currency);
			orderReq.put("receipt", receipt);
			orderReq.put("payment_capture", 1); //Auto-generate Payment
			
			Order order = razorCli.orders.create(orderReq);
			return order.get("id").toString();
				
	}

	public String getRazorpayKeyId() {
		return razorpayKeyId;
	}

	@Override
	public boolean verifyPayment(String paymentId, String orderId) throws RazorpayException {
		RazorpayClient razorCli = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
		Payment payment = razorCli.payments.fetch(paymentId);
		
		return payment.get("order_id").equals(orderId) && payment.get("status").equals(("captured"));
	}

}
