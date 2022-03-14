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
@Table(name = "creatinine_dosages")
public class CreatinineBasedDosage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String creatinine_clearance;
    @Column(columnDefinition = "TEXT")
    private String dosage_fraction;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creatinine_clearance == null) ? 0 : creatinine_clearance.hashCode());
        result = prime * result + ((dosage_fraction == null) ? 0 : dosage_fraction.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        CreatinineBasedDosage other = (CreatinineBasedDosage) obj;
        if (creatinine_clearance == null) {
            if (other.creatinine_clearance != null)
                return false;
        } else if (!creatinine_clearance.equals(other.creatinine_clearance))
            return false;
        if (dosage_fraction == null) {
            if (other.dosage_fraction != null)
                return false;
        } else if (!dosage_fraction.equals(other.dosage_fraction))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String getCreatinine_clearance() {
        return creatinine_clearance;
    }

    public void setCreatinine_clearance(String creatinine_clearance) {
        this.creatinine_clearance = creatinine_clearance;
    }

    public String getDosage_fraction() {
        return dosage_fraction;
    }

    public void setDosage_fraction(String dosage_fraction) {
        this.dosage_fraction = dosage_fraction;
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
