package com.example.ddd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "cin")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cin;

    @Column(name = "password")
    private String password;
}
