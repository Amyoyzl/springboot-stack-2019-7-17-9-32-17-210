package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "prosecutor")
public class Prosecutor {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
