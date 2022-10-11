package com.example.BudgetApp.transaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    //Strona zadziała, jak ma jakieś powiązane z nazwą controllery, a jak nie to pokaże, że nie ma takiej strony (404)
    @GetMapping("/transaction")
    public Transaction getTransaction() {
        return new Transaction();
    }
}
