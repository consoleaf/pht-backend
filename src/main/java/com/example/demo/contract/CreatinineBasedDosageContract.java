package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.CreatinineBasedDosage;

public class CreatinineBasedDosageContract implements Serializable {
    public CreatinineBasedDosageContract() {
    }

    private Long id;

    public CreatinineBasedDosageContract(CreatinineBasedDosage t) {
        this.setCreatinine_clearance(t.getCreatinine_clearance());
        this.setDosage_fraction(t.getDosage_fraction());
        this.setId(t.getId());
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

    private String creatinine_clearance;
    private String dosage_fraction;

    public CreatinineBasedDosage toEntity() {
        CreatinineBasedDosage entity = new CreatinineBasedDosage();
        entity.setCreatinine_clearance(creatinine_clearance);
        entity.setDosage_fraction(dosage_fraction);
        entity.setId(id);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
