package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.PharmKinetic;

public class PharmKineticContract implements Serializable {
    public PharmKineticContract() {
    }

    public PharmKineticContract(PharmKinetic kin) {
        this.setId(kin.getId());
        this.setName(kin.getName());
        this.setValue(kin.getValue());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    private String value;

    public PharmKinetic toEntity() {
        PharmKinetic ret = new PharmKinetic();
        ret.setId(this.id);
        ret.setName(this.name);
        ret.setValue(this.value);
        return ret;
    }
}
