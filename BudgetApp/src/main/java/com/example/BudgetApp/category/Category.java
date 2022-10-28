package com.example.BudgetApp.category;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @Type(type="org.hibernate.type.UUIDCharType")

    private UUID id;

    @Column(name = "category_budget")
    @NotBlank
    @NonNull
    private BigDecimal budget;

    @Column(name = "category_name")
    @NotBlank
    @NonNull
    private String name;

    @Column(name = "category_startDate")
    @NotBlank
    @NonNull
    private String startDate;

    @Column(name = "category_endDate")
    @NotBlank
    @NonNull
    private String endDate;
}
