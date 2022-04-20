package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.contract.ActingSubstanceContract;
import com.example.demo.contract.ActingSubstanceOrDrugBriefContract;
import com.example.demo.contract.DrugContract;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.entities.ActingSubstance;
import com.example.demo.model.entities.Drug;
import com.example.demo.repositories.ActingSubstanceRepository;
import com.example.demo.util.OffsetBasedPageRequest;

import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ActingSubstancesService implements IActingSubstancesService {
    @Autowired
    private ActingSubstanceRepository repository;

    @Override
    public List<ActingSubstance> getPage(int offset, int limit) {
        Pageable pageable = new OffsetBasedPageRequest(offset, limit);
        return this.repository.findAll(pageable).toList();
    }

    @Override
    public ActingSubstance getById(Long id) {
        var subst = this.repository.findById(id);
        return subst.orElseThrow(() -> new NotFoundException("Acting substance " + id + " not found"));
    }

    @Override
    public List<ActingSubstanceOrDrugBriefContract> getBrief(String search) {
        var substs = repository.findAllByInpName(search, null).stream()
                .map(ActingSubstanceOrDrugBriefContract::new);
        return substs.collect(Collectors.toList());
    }

    @Override
    public ActingSubstance createSubstance(ActingSubstanceContract val) {
        ActingSubstance substance = val.toEntity();
        return repository.save(substance);
    }

    @Override
    public ActingSubstance updateOrCreate(ActingSubstanceContract contract) {
        ActingSubstance actingSubstance = repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(ActingSubstance::new);


        Util.assignIfNotNull(contract::getName, actingSubstance::setName);

        return actingSubstance;
    }
}
