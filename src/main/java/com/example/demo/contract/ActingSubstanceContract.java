package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.ActingSubstance;

public class ActingSubstanceContract implements Serializable {
    public ActingSubstanceContract() {
    }

    public ActingSubstanceContract(ActingSubstance actingSubstance) {
        this.name = actingSubstance.getName();
        this.id = actingSubstance.getId();
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

    private Long id;
    private String name;

    public ActingSubstance toEntity() {
        ActingSubstance actingSubstance = new ActingSubstance();
        actingSubstance.setId(id);
        actingSubstance.setName(name);
        return actingSubstance;
    }
}
