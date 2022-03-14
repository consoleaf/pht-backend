package com.example.demo.contract;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.entities.Drug;

public class LiverDosageInfoContract implements Serializable {
    public LiverDosageInfoContract() {
    }

    public LiverDosageInfoContract(Drug drug) {
        setDose_change_prerequisites(drug.getDose_change_prerequisites());
        setCreatinine_based_dosages(drug.getCreatinine_based_dosages().stream()
                .map(t -> new CreatinineBasedDosageContract(t)).collect(Collectors.toList()));
    }

    public String getDose_change_prerequisites() {
        return dose_change_prerequisites;
    }

    public void setDose_change_prerequisites(String dose_change_prerequisites) {
        this.dose_change_prerequisites = dose_change_prerequisites;
    }

    public List<CreatinineBasedDosageContract> getCreatinine_based_dosages() {
        return creatinine_based_dosages;
    }

    public void setCreatinine_based_dosages(List<CreatinineBasedDosageContract> creatinine_based_dosages) {
        this.creatinine_based_dosages = creatinine_based_dosages;
    }

    private String dose_change_prerequisites;
    private List<CreatinineBasedDosageContract> creatinine_based_dosages;
}
