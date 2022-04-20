package com.example.demo.services;

import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.DrugContract;
import com.example.demo.exceptions.BadRequestException;
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

    @Autowired
    private IActingSubstancesService actingSubstancesService;


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
    public Drug updateDrug(DrugContract drugContract) {
        Drug drug = repository.findById(Optional.ofNullable(drugContract.getId()).orElseThrow(BadRequestException::new)).orElseThrow(BadRequestException::new);

        // Refresh fields
        updateDrugFields(drugContract, drug);

        // TODO: Refresh relationships and related entities
        drug.getDosages();
        drug.getInteractions();
        drug.getActing_substance();
        drug.getCreatinine_based_dosages();
        drug.getPharm_kinetics();
        drug.getTrade_names();
        drug.getSide_effects();

        return repository.save(drug);
    }

    private void updateDrugFields(DrugContract drugContract, Drug drug) {
        drug.setDose_change_prerequisites(drugContract.getLiver_dosage_info().getDose_change_prerequisites());
        drug.setFda_category(drugContract.getPregnancy_info().getFda_category());
        drug.setFirst_line(drugContract.getFirst_line());
        drug.setFood_comment(drugContract.getFood_info().getComment());
        drug.setFood_recommendations(drugContract.getFood_info().getRecommendations());
        drug.setInp_name(drugContract.getInp_name());
        drug.setContraindications(drugContract.getContraindications());
        drug.setPharm_dynamics(drugContract.getPharm_dynamics());
        drug.setPregnancy_additional_info(drugContract.getPregnancy_info().getAdditional_info());
        drug.setPregnancy_usage(drugContract.getPregnancy_info().getUsage());
        drug.setRole_in_treatment(drugContract.getRole_in_treatment());
    }

    @Transactional
    @Override
    public Drug createDrug(DrugContract drugContract) {
        Drug drug = repository.findById(Optional.ofNullable(drugContract.getId()).orElse(-1L)).orElse(new Drug());

        updateDrugFields(drugContract, drug);

        drug.setActing_substance(drugContract.getActing_substance().toEntity());
        drug.getActing_substance().setDrug(drug);

        if (drug.getCreatinine_based_dosages() == null) drug.setCreatinine_based_dosages(new HashSet<>());
        drug.getCreatinine_based_dosages().clear();
        drug.getCreatinine_based_dosages().addAll(drugContract.getLiver_dosage_info().getCreatinine_based_dosages().stream()
                .map(v -> {
                    var entity = v.toEntity();
                    entity.setDrug(drug);
                    return entity;
                }).collect(Collectors.toSet()));
        if (drug.getDosages() == null) drug.setDosages(new HashSet<>());
        drug.getDosages().clear();
        drug.getDosages().addAll(drugContract.getDosages().stream().map(v -> {
            var entity = v.toEntity();
            entity.setDrug(drug);
            return entity;
        }).collect(Collectors.toSet()));
        if (drug.getInteractions() == null) drug.setInteractions(new HashSet<>());
        drug.getInteractions().clear();
        drug.getInteractions().addAll(drugContract.getInteractions().stream().map(i -> {
            var entity = i.toEntity();
            entity.setDrug(drug);
            return entity;
        }).collect(Collectors.toSet()));
        drug.setPharm_dynamics(drugContract.getPharm_dynamics());
        if (drug.getPharm_kinetics() == null) drug.setPharm_kinetics(new HashSet<>());
        drug.getPharm_kinetics().clear();
        drug.getPharm_kinetics().addAll(drugContract.getPharm_kinetics().stream().map(i -> {
            var entity = i.toEntity();
            entity.setDrug(drug);
            return entity;
        }).collect(Collectors.toSet()));
        if (drug.getSide_effects() == null) drug.setSide_effects(new HashSet<>());
        drug.getSide_effects().clear();
        drug.getSide_effects().addAll(drugContract.getSide_effects().stream().map(i -> {
            var entity = i.toEntity();
            entity.setDrug(drug);
            return entity;
        }).collect(Collectors.toSet()));
        if (drug.getTrade_names() == null) drug.setTrade_names(new HashSet<>());
        drug.getTrade_names().clear();
        drug.getTrade_names().addAll(drugContract.getTrade_names().stream().map(i -> {
            var entity = i.toEntity();
            entity.setDrug(drug);
            return entity;
        }).collect(Collectors.toSet()));
        actingSubstanceRepository.save(drug.getActing_substance());
        actingSubstanceRepository.saveAll(drug.getInteractions().stream().map(Interaction::getActingSubstance).collect(Collectors.toUnmodifiableSet()));
        return repository.save(drug);
    }
}
