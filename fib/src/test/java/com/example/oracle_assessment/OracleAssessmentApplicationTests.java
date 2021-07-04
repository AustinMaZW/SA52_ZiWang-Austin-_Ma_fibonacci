package com.example.oracle_assessment;

import com.example.oracle_assessment.fib.FibRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OracleAssessmentApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OracleAssessmentApplicationTests {

    @Autowired
    FibRepository frepo;

    @Test
    @Order(1)
    public void addFibNumbers() {
        //List<Integer> id = IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
        //id.stream().forEach(System.out::println);
    }

}
