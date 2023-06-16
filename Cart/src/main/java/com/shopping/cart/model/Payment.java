package com.shopping.cart.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int paymentId;
    String personName;
    double cardNumber;
    String expiry;
    int cvv;
    double totalProductPrice;
}

/* sample input json
{"personName":"abc",
"cardNumber":1010101010101010,
"expiry":"02/2024",
"cvv":123,
"totalProductPrice":1000}
*/
