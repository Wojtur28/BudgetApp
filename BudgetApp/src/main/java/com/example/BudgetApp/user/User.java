package com.example.BudgetApp.user;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @Type(type="org.hibernate.type.UUIDCharType")

    private UUID id;

    @Column(name = "first_name")
    @NonNull
    @NotBlank
    private String userFirstName;

    @Column(name = "last_name")
    @NonNull
    @NotBlank
    private String userLastName;

    @Column(name = "email")
    @NonNull
    @NotBlank
    private String email;

    @Column(name = "password")
    @NonNull
    @NotBlank
    private String password;




}

