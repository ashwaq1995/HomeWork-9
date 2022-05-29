package com.demo.DBProject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class User {

    @Id
    private String id;

    @Column(name ="user_name", nullable = false, unique = true)
    private String username;

    private String email;

    private String password;

}

