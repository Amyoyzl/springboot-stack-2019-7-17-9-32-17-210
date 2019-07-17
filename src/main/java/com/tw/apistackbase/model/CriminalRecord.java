package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table(name = "criminal_case_record")
public class CriminalRecord {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, name = "objective_description")
    private String objectiveDescription;

    @Column(nullable = false, name = "subjective_description")
    private String subjectiveDescription;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }
}
