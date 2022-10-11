package com.example.BudgetApp.transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Transaction {

    UUID id;
    Date date;
    BigDecimal total;
    String type;
    String description;
}
