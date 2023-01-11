package com.wtongze.innospace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String password;

    private String name;

    @Size(max = 100)
    private String description;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String roles;

    @Column(nullable = false)
    private boolean enabled;
}
