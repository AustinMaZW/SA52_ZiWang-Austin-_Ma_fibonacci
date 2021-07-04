package com.example.oracle_assessment.fib;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private List<BigInteger> fibonacci;
    private List<BigInteger> sorted;
}
