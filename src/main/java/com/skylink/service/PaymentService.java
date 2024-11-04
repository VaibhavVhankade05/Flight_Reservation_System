package com.skylink.service;

import java.util.List;
import java.util.Optional;

import com.skylink.entity.Payment;

public interface PaymentService 
{
	
	Payment addPayment(Payment payment);
	
    List<Payment> getAllPayments();
    
    Optional<Payment> getPaymentById(Long id);
    
    Payment updatePayment(Long id, Payment paymentDetails);
    
    void deletePayment(Long id);

}
