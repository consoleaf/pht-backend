package com.example.demo.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dosages")
public class Dosage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean adult;
    @Column(columnDefinition = "TEXT")
    private String pharm_form;
    @Column(columnDefinition = "TEXT")
    private String daily_dose;
    @Column(columnDefinition = "TEXT")
    private String max_daily_dose;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adult == null) ? 0 : adult.hashCode());
        result = prime * result + ((daily_dose == null) ? 0 : daily_dose.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((max_daily_dose == null) ? 0 : max_daily_dose.hashCode());
        result = prime * result + ((pharm_form == null) ? 0 : pharm_form.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dosage other = (Dosage) obj;
        if (adult == null) {
            if (other.adult != null)
                return false;
        } else if (!adult.equals(other.adult))
            return false;
        if (daily_dose == null) {
            if (other.daily_dose != null)
                return false;
        } else if (!daily_dose.equals(other.daily_dose))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (max_daily_dose == null) {
            if (other.max_daily_dose != null)
                return false;
        } else if (!max_daily_dose.equals(other.max_daily_dose))
            return false;
        if (pharm_form == null) {
            if (other.pharm_form != null)
                return false;
        } else if (!pharm_form.equals(other.pharm_form))
            return false;
        return true;
    }

    public String getMax_daily_dose() {
        return max_daily_dose;
    }

    public void setMax_daily_dose(String max_daily_dose) {
        this.max_daily_dose = max_daily_dose;
    }

    public String getDaily_dose() {
        return daily_dose;
    }

    public void setDaily_dose(String daily_dose) {
        this.daily_dose = daily_dose;
    }

    public String getPharm_form() {
        return pharm_form;
    }

    public void setPharm_form(String pharm_form) {
        this.pharm_form = pharm_form;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
