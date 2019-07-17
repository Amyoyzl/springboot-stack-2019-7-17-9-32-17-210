package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procuratorate")
public class Procuratorate {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, columnDefinition = "varchar(50)", unique = true)
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
