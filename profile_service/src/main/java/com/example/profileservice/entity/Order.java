package com.example.profileservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "orders")
public class Order {
    @Transient
    public static final String SEQUENCE_Name = "order_sequence";
    @Id
    private int id;
    private double cost;

    private LocalDate date;
    private int quantity;
    private String couponName;
    private String userName;
    private String userEmail;

}
