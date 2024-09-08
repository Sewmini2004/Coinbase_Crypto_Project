package com.example.Coinbase_Crypto.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Object hello(){
        Map<String,String> object = new HashMap<>();
        System.out.println("Hello called");
        object.put("name","Sewmini Pramodya");
        object.put("email","sewminipremodya98@gmail.com");
        return object;
    }
}
