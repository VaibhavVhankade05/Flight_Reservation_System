package com.skylink.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylink.entity.Payment;
import com.skylink.repository.PaymentRepository;
import com.skylink.service.PaymentService;


@Service
public class PaymentImplementation implements PaymentService
{
	
	@Autowired
	private PaymentRepository paymentRepository;


	
//	Add Payment
	@Override
	public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }


	
//	Payment List 
	@Override
	public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
	
	
	
//	Payment By Id
	@Override
	public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }
	
	
	
//	Update
	@Override
	public Payment updatePayment(Long id, Payment paymentDetails) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setTransactionId(paymentDetails.getTransactionId());
            payment.setPaymentStatus(paymentDetails.getPaymentStatus());
            payment.setBooking(paymentDetails.getBooking());
            return paymentRepository.save(payment);
        }).orElseThrow(() -> new RuntimeException("Payment Not Found with ID " + id));
    }
	
	
	
	
//	Delete
	@Override
	public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment Not Found with ID " + id);
        }
        paymentRepository.deleteById(id);
    }
	
	

}
