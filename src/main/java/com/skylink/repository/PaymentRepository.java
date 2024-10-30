package com.skylink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylink.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{

}
