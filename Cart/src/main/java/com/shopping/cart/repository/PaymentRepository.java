package com.shopping.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.cart.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
 
}
