package com.example.demo.services.interfaces;

import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.DrugContract;
import com.example.demo.model.entities.Drug;
import com.example.demo.model.entities.Interaction;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IDrugService {
  List<Drug> getPage(int offset, int limit);

  Drug getById(Long drugId);

  List<ActingSubstanceOrDrugBriefContract> getBriefDrugs(String search);

    @Transactional
    Drug updateDrug(DrugContract drugContract);

    Drug createDrug(DrugContract drug);

  List<Interaction> getInteraction(Long drugId, Long substanceId);

  void delete(Long drugId);
}
