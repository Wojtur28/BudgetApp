package com.example.BudgetApp.transaction;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @Type(type="org.hibernate.type.UUIDCharType")

    private UUID id;


    @Column(name = "transaction_date")
    @NonNull
    @NotBlank
    private Date transactionDate;

    @Column(name = "transaction_amount")
    @NonNull
    @NotBlank
    private BigDecimal transactionAmount;

    @Column(name = "transaction_description")
    @NonNull
    @NotBlank
    private String transactionDescription;

    @Column(name = "transaction_category")
    @NonNull
    @NotBlank
    private String transactionType;



}
