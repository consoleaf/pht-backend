package com.example.demo.contract;

import com.example.demo.model.entities.Feedback;

import java.sql.Timestamp;

public class FeedbackContract {
    private Long id;
    private String content;
    private String email;
    private Boolean is_medical_professional;
    private Boolean is_processed;
    private Timestamp timestamp;

    public FeedbackContract(Feedback entity) {
        setId(entity.getId());
        setContent(entity.getContent());
        setEmail(entity.getEmail());
        setIs_medical_professional(entity.getMedicalProfessional());
        setIs_processed(entity.getProcessed());
        setTimestamp(entity.getTimestamp());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_medical_professional() {
        return is_medical_professional;
    }

    public void setIs_medical_professional(Boolean is_medical_professional) {
        this.is_medical_professional = is_medical_professional;
    }

    public Boolean getIs_processed() {
        return is_processed;
    }

    public void setIs_processed(Boolean is_processed) {
        this.is_processed = is_processed;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
