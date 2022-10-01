package com.example.BudgetApp.user.model;

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
