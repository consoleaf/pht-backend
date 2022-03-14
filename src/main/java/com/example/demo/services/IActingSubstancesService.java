package com.example.demo.services;

import java.util.List;

import com.example.demo.contract.ActingSubstanceContract;
import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.model.entities.ActingSubstance;

public interface IActingSubstancesService {
    public List<ActingSubstance> getPage(int offset, int limit);

    public ActingSubstance getById(Long id);

    public List<ActingSubstanceOrDrugBriefContract> getBrief(String search);

    public ActingSubstance createDrug(ActingSubstanceContract drug);
}
