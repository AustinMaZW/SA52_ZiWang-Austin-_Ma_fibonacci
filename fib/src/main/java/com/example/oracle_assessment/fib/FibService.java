package com.example.oracle_assessment.fib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.*;

@Service
public class FibService {

    @Autowired
    FibRepository frepo;

    public Mono<Result> getResult(int elements){
        List<FibonacciNum> fibDocs = frepo.retrieveAllNumsPaged(PageRequest.of(0, elements));      //retrieve first nth docs
        List<BigInteger> fibNums = getAllFibByElements(fibDocs);
        List<BigInteger> fibNumsSorted = sortFibs(fibNums);

        Result result = new Result(fibNums, fibNumsSorted);     //create wrapper for the two lists
        return Mono.just(result);       //transform to mono
    }

    public List<BigInteger> getAllFibByElements(List<FibonacciNum> fibDocs){
        List<BigInteger> fibNums = new ArrayList<>();
        fibDocs.stream().forEach(x->{
            fibNums.add(x.getNumber());        //add the fibs numbers to list
        });
        return fibNums;
    }

    public List<BigInteger> sortFibs(List<BigInteger> nums) {
        List<BigInteger> even = new ArrayList<>();
        List<BigInteger> odd = new ArrayList<>();
        List<BigInteger> sorted = new ArrayList<>();
        nums.stream().forEach(x->{             //separate into even and odd list
            if(x.mod(new BigInteger("2")).equals(BigInteger.ZERO)){
                even.add(x);
            }else{
                odd.add(x);
            }
        });
        Collections.sort(even,Collections.reverseOrder());      //sort even and odd by descending
        Collections.sort(odd,Collections.reverseOrder());

        sorted.addAll(even);            //add the sorted even and odd lists
        sorted.addAll(odd);

        return sorted;
    }
}
