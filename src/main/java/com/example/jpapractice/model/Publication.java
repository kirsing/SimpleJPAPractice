package com.example.jpapractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Publication {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;
 
    @Column
    protected String title;
 
    @Version
    @Column(name = "version")
    private int version;
 
    @Column
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

}