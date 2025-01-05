package com.tekarch.AccountMS.Controller;

import com.tekarch.AccountMS.Service.AccountServiceImpl;
import com.tekarch.AccountMS.models.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/accounts")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;


    @PostMapping
    public ResponseEntity<Accounts> createAccount(@RequestBody Accounts account){
        Accounts createdAccount = accountService.addAccount(account);
        return new ResponseEntity<>(createdAccount,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Accounts>>getAllAccounts(){
    return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable Long id)
    {
     Accounts accounts = accountService.getAccountById(id);
     if(accounts != null) {
         return new ResponseEntity<>(accounts , HttpStatus.OK);
     }
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        if(!accountService.getAccountById(id).getAccountId().equals(0L)){
            accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
    }

}
