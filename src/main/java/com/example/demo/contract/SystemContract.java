package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.System;

public class SystemContract implements Serializable {
    public SystemContract() {
    }

    public SystemContract(System system2) {
        this.setId(system2.getId());
        this.setSystem(system2.getSystem());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    private Long id;
    private String system;

    public System toEntity() {
        System system = new System();
        system.setId(id);
        system.setSystem(this.system);
        return system;
    }
}
