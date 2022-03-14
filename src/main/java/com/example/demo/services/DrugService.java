package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.DrugContract;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.entities.ActingSubstance;
import com.example.demo.model.entities.Drug;
import com.example.demo.model.entities.Interaction;
import com.example.demo.repositories.ActingSubstanceRepository;
import com.example.demo.repositories.DrugRepository;
import com.example.demo.util.OffsetBasedPageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DrugService implements IDrugService {
    @Autowired
    private DrugRepository repository;

    @Autowired
    private ActingSubstanceRepository actingSubstanceRepository;

    @Override
    public List<Drug> getPage(int offset, int limit) {
        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return this.repository.findAll(pageable).toList();
    }

    @Override
    public Drug getById(Long drugId) {
        Optional<Drug> drug = this.repository.findById(drugId);
        return drug.orElseThrow(() -> new NotFoundException("Drug " + drugId + " not found"));
    }

    @Override
    public List<Interaction> getInteraction(Long drugId, Long substanceId) {
        return getInteraction(drugId, substanceId, true);
    }

    public List<Interaction> getInteraction(Long drugId, Long substanceId, Boolean cont) {
        Optional<Drug> drugOpt = this.repository.findById(drugId);
        drugOpt.orElseThrow(() -> new NotFoundException("Drug not found"));
        var interaction = drugOpt.get().getInteractions().stream()
                .filter(i -> i.getActingSubstance().getId().equals(substanceId)).findFirst();
        var res = new ArrayList<Interaction>();
        if (interaction.isPresent()) {
            res.add(interaction.get());
        }

        if (cont) {
            var substance = this.actingSubstanceRepository.findById(substanceId);
            var substOfDrug = this.actingSubstanceRepository.findByDrugId(drugId);
            if (substance.isPresent() && substOfDrug.isPresent()) {
                var substDrug = substance.get().getDrug();
                if (substDrug != null) {
                    res.addAll(this.getInteraction(substDrug.getId(), substOfDrug.get().getId(), false));
                }
            }
        }

        return res;
    }

    @Override
    public List<ActingSubstanceOrDrugBriefContract> getBriefDrugs(String search) {
        var drugs = repository.findAllByInpName(search, null).stream()
                .map((drug) -> new ActingSubstanceOrDrugBriefContract(drug));
        return drugs.collect(Collectors.toList());
    }

    @Override
    public Drug createDrug(DrugContract drugContract) {
        Drug drug = drugContract.toDrug();
        return repository.save(drug);
    }
}
