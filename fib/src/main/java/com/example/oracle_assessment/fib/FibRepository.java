package com.example.oracle_assessment.fib;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FibRepository extends MongoRepository<FibonacciNum, String> {

    @Query(value = "{ id: { $exists: true }}")
    List<FibonacciNum> retrieveAllNumsPaged(Pageable page);     //using Pageable to retrieve first nth elements
}
