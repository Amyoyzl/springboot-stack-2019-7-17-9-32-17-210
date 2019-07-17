package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table(name = "criminal_case")
public class Criminal {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Column(nullable = false)
    private long time;

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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}