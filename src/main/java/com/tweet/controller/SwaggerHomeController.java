package com.tweet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SwaggerHomeController {

    @RequestMapping(value = "/mytwitter")
    public String index() {
        return "redirect:/swagger-ui.html";
    }
}
