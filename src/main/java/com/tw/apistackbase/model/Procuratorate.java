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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "procuratorate_id")
    private List<Prosecutor> prosecutors;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "procuratorate_id")
    private List<Criminal> criminals;

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

    public List<Criminal> getCriminals() {
        return criminals;
    }

    public void setCriminals(List<Criminal> criminals) {
        this.criminals = criminals;
    }
}
