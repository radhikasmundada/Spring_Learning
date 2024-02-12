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

    private String emailId; // Write in camel case it will take email_ID



}
