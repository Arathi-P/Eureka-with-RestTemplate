package com.i2i.first.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/one")
public class FirstServiceController {

    @GetMapping
    public String getFromServiceOne() {
        return "From service A";
    }

}