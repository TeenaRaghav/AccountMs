package com.tekarch.AccountMS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/account")
    public String getAccount(){
        return "This is Account microservices";
    }
}
