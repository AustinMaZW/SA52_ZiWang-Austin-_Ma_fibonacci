package com.example.oracle_assessment.fib;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FibonacciNum {
    @Id
    private String id;
    private int element;
    private BigInteger number;

    public FibonacciNum(Integer element, BigInteger number) {
        this.element = element;
        this.number = number;
    }
}
