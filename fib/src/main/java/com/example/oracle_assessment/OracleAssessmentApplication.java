package com.example.oracle_assessment;

import com.example.oracle_assessment.fib.FibRepository;
import com.example.oracle_assessment.fib.FibonacciNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EnableMongoRepositories(basePackageClasses = FibRepository.class)
@SpringBootApplication
public class OracleAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(OracleAssessmentApplication.class, args);
    }

    //Below code to insert data
    @Bean
    CommandLineRunner runner(FibRepository repository){
        return args -> {
            List<Integer> id = IntStream.rangeClosed(1,99).boxed().collect(Collectors.toList());
            FibonacciNum firstFib = new FibonacciNum(1,BigInteger.ZERO);
            repository.save(firstFib);
            id.stream().forEach(x->{
                BigInteger n = fib(x);
                FibonacciNum fibN = new FibonacciNum(x+1, n);
                System.out.println(fibN);
                repository.save(fibN);
            });
        };
    }

    public BigInteger fib (int index){
        BigInteger a = BigInteger.valueOf(0), b = BigInteger.valueOf(1), c;
        if(index==0) {
            return a;
        }
        for (int i = 2; i<=index; i++){
            c = a.add(b);
            a = b;
            b = c;
        }
        return b;
    }

}
