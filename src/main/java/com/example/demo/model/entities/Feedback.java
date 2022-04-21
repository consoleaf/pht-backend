package com.example.demo.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Feedback {
    @Id
    private Long id;

    private String email;
    private String name;
    private Timestamp timestamp;
    private String content;
    private Boolean isMedicalProfessional;
    private Boolean isProcessed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getMedicalProfessional() {
        return isMedicalProfessional;
    }

    public void setMedicalProfessional(Boolean medicalProfessional) {
        isMedicalProfessional = medicalProfessional;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }
}
