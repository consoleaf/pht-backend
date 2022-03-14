package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.Dosage;

public class DosageContract implements Serializable {
    public DosageContract() {
    }

    public DosageContract(Dosage dosage) {
        this();
        this.adult = dosage.getAdult();
        this.daily_dose = dosage.getDaily_dose();
        this.max_daily_dose = dosage.getMax_daily_dose();
        this.id = dosage.getId();
        this.pharm_form = dosage.getPharm_form();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getPharm_form() {
        return pharm_form;
    }

    public void setPharm_form(String pharm_form) {
        this.pharm_form = pharm_form;
    }

    public String getDaily_dose() {
        return daily_dose;
    }

    public void setDaily_dose(String daily_dose) {
        this.daily_dose = daily_dose;
    }

    public String getMax_daily_dose() {
        return max_daily_dose;
    }

    public void setMax_daily_dose(String max_daily_dose) {
        this.max_daily_dose = max_daily_dose;
    }

    private Long id;
    private Boolean adult;
    private String pharm_form;
    private String daily_dose;
    private String max_daily_dose;

    public Dosage toEntity() {
        var dosage = new Dosage();
        dosage.setId(id);
        dosage.setAdult(adult);
        dosage.setDaily_dose(daily_dose);
        dosage.setMax_daily_dose(max_daily_dose);
        dosage.setPharm_form(pharm_form);
        return dosage;
    }
}
