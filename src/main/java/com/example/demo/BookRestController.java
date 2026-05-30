package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

@RestController 
public class BookRestController {

    @GetMapping("/test")
    public String hellowWorld{
        return "Hello World";
    }




}