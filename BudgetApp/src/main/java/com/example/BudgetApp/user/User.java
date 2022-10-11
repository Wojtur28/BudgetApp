package com.example.BudgetApp.user;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    private String userFirstName;
    @Column(name = "last_name")
    @NonNull
    private String userLastName;
    @Column(name = "email")
    @NonNull
    private String email;
    @Column(name = "password")
    @NonNull
    private String password;



}

