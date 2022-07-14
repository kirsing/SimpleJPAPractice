package com.example.jpapractice.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_notification")
//@DiscriminatorValue("EMAIL NOTIFICATION")
public class EmailNotification extends Notification {
 
    @Column(
        name = "email_address",
        nullable = false
    )
    private String emailAddress;
 
    //Getters and setters omitted for brevity
}