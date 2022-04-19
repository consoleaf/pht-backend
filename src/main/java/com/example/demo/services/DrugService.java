package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.DrugContract;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.entities.Drug;
import com.example.demo.model.entities.Interaction;
import com.example.demo.repositories.*;
import com.example.demo.util.OffsetBasedPageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DrugService implements IDrugService {
    @Autowired
    private ActingSubstanceRepository actingSubstanceRepository;
    @Autowired
    private DrugRepository repository;


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
        interaction.ifPresent(res::add);

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
                .map(ActingSubstanceOrDrugBriefContract::new);
        return drugs.collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Drug createDrug(DrugContract drugContract) {
        Drug drug = new Drug();

        drug.setActing_substance(drugContract.getActing_substance().toEntity());
        drug.getActing_substance().setDrug(drug);
        drug.setContraindications(drugContract.getContraindications());
        drug.setCreatinine_based_dosages(drugContract.getLiverDosageInfo().getCreatinine_based_dosages().stream()
                .map(v -> v.toEntity()).collect(Collectors.toSet()));
        drug.setDosages(drugContract.getDosages().stream().map(v -> v.toEntity()).collect(Collectors.toSet()));
        drug.setDose_change_prerequisites(drugContract.getLiverDosageInfo().getDose_change_prerequisites());
        drug.setFda_category(drugContract.getPregnancy_info().getFda_category());
        drug.setFirst_line(drugContract.getFirst_line());
        drug.setFood_comment(drugContract.getFoodInfo().getComment());
        drug.setFood_recommendations(drugContract.getFoodInfo().getRecommendations());
        drug.setInp_name(drugContract.getInp_name());
        drug.setInteractions(drugContract.getInteractions().stream().map(i -> i.toEntity()).collect(Collectors.toSet()));
        drug.setPharm_dynamics(drugContract.getPharm_dynamics());
        drug.setPharm_kinetics(drugContract.getPharm_kinetics().stream().map(i -> i.toEntity()).collect(Collectors.toSet()));
        drug.setPregnancy_additional_info(drugContract.getPregnancy_info().getAdditional_info());
        drug.setPregnancy_usage(drugContract.getPregnancy_info().getUsage());
        drug.setRole_in_treatment(drugContract.getRole_in_treatment());
        drug.setSide_effects(drugContract.getSide_effects().stream().map(i -> i.toEntity()).collect(Collectors.toSet()));
        drug.setTrade_names(drugContract.getTrade_names().stream().map(i -> i.toEntity()).collect(Collectors.toSet()));
        return repository.save(drug);
    }
}
