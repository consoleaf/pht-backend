package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.ActingSubstance;
import com.example.demo.model.entities.Drug;

public class ActingSubstanceOrDrugBriefContract implements Serializable {
    private Long id;

    public ActingSubstanceOrDrugBriefContract() {
    }

    public ActingSubstanceOrDrugBriefContract(Drug drug) {
        this.id = drug.getId();
        this.name = drug.getInp_name();
    }

    public ActingSubstanceOrDrugBriefContract(ActingSubstance subst) {
        this.id = subst.getId();
        this.name = subst.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
