package com.example.certi.veri.services;

import com.razorpay.RazorpayException;

public interface TransactionService {
	String createOrder(float amount, String currency, String receipt) throws RazorpayException;
	boolean verifyPayment(String paymentId, String orderId) throws RazorpayException;
}
