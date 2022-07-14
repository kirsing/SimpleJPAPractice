package com.example.jpapractice.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sms_notification")
//@DiscriminatorValue("SMS NOTIFICATION")
public class SmsNotification
    extends Notification {
 
    @Column(
        name = "phone_number",
        nullable = false
    )
    private String phoneNumber;
 
    //Getters and setters omitted for brevity
}


// 4 пары наследования (правила) + репа к каждой + контроллер