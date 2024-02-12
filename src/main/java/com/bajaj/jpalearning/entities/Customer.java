package com.bajaj.jpalearning.entities;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // To auto increament
    private int id;

    @Column(name="name") //Name of the table
    private String name;

    private int age;

    @Column(unique = true)
    private String emailId; // Write in camel case it will take email_ID

    private String password;

    public Customer(String name, int age, String emailId, String password) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
