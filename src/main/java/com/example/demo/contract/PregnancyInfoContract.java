package com.example.demo.contract;

import java.io.Serializable;

import com.example.demo.model.entities.Drug;

public class PregnancyInfoContract implements Serializable {
    public PregnancyInfoContract() {
    }

    public PregnancyInfoContract(Drug drug) {
        this.setFda_category(drug.getFda_category());
        this.setUsage(drug.getPregnancy_usage());
        this.setAdditional_info(drug.getPregnancy_additional_info());
    }

    public String getFda_category() {
        return fda_category;
    }

    public void setFda_category(String fda_category) {
        this.fda_category = fda_category;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    private String fda_category;
    private String usage;
    private String additional_info;
}
