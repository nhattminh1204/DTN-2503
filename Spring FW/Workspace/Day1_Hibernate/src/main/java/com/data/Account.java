package com.data;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id // khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự tăng
    private int id;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                ", Username:'" + username + '\'' +
                ", Password:'" + password + '\'' ;
    }
}
