package com.tekarch.AccountMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/accounts")
public class AccountController {
    @Autowired

    @GetMapping("/account")
    public String getAccount(){
        return "This is Account microservices";
    }
}
