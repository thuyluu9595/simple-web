package com.example.simpleweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleWebController {

    @GetMapping("/")
    public User index(){
        return new User("Thuy","thuyluu9595@gmail.com", "abc123");
    }
}
