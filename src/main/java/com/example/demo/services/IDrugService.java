package com.example.demo.services;

import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.DrugContract;
import com.example.demo.model.entities.Drug;
import com.example.demo.model.entities.Interaction;
import java.util.List;
import java.util.Optional;

public interface IDrugService {
  public List<Drug> getPage(int offset, int limit);

  public Drug getById(Long drugId);

  public List<ActingSubstanceOrDrugBriefContract> getBriefDrugs(String search);

  public Drug createDrug(DrugContract drug);

  public List<Interaction> getInteraction(Long drugId, Long substanceId);
}
