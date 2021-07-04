package com.example.oracle_assessment.fib;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
public class FibController {

    @Autowired
    FibService fservice;

    @GetMapping("/fibonacci")
    public Mono<Result> findFibNums(@RequestBody String json){
        JSONObject object = new JSONObject(json);       //using org.JSON library to parse
        int elements = object.getInt("elements");   //retrieve elements value
        return fservice.getResult(elements);            //pass to FibService to get seq and sorted seq
    }
}
