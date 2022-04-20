package com.example.demo.services;

import java.util.List;

import com.example.demo.contract.ActingSubstanceContract;
import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.model.entities.ActingSubstance;

public interface IActingSubstancesService {
    List<ActingSubstance> getPage(int offset, int limit);

    ActingSubstance getById(Long id);

    List<ActingSubstanceOrDrugBriefContract> getBrief(String search);

    ActingSubstance createSubstance(ActingSubstanceContract drug);

    ActingSubstance updateOrCreate(ActingSubstanceContract contract);
}
