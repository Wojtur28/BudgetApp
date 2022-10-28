package com.example.BudgetApp.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public ResponseEntity<List<Transaction>>getAllTransactions() {
        try{
            return new ResponseEntity<>(transactionRepository.findAll(), HttpStatus.FOUND);
        } catch (Exception e) {
            log.error("Error with \"getAllTransactions\"");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Transaction> getTransactionById (UUID id) {
        Optional<Transaction> transactionData = transactionRepository.findById(id);
        if(transactionData.isPresent()) {
            return new ResponseEntity<>(transactionData.get(), HttpStatus.OK);
        } else {
            log.info("Transaction not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Transaction> addTransaction(Transaction transaction) {
        try {
            Transaction _transaction = transactionRepository.save(new Transaction(transaction.getTransactionDate(), transaction.getTransactionAmount(), transaction.getTransactionDescription(), transaction.getTransactionType()));
            return new ResponseEntity<>(_transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info("createTransaction exception: "+ transaction.toString()+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Transaction> updateTransaction(Transaction transaction) {
        try {
            Transaction transactionItemData = transactionRepository.findById(transaction.getId()).stream()
                    .findFirst()
                    .orElse(null);
            if(transactionItemData == null)
                throw new Exception();
            return new ResponseEntity<>(transactionRepository.save(transaction), HttpStatus.OK);
        } catch (Exception e) {
            log.info("updateTransaction exception: " + transaction.toString() + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> deleteTransaction(UUID id) {
        try {
            transactionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info("deleteTransaction exception: " + id.toString() + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
