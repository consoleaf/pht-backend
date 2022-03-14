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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
                .map((subst) -> new ActingSubstanceOrDrugBriefContract(subst));
        return substs.collect(Collectors.toList());
    }

    @Override
    public ActingSubstance createDrug(ActingSubstanceContract val) {
        ActingSubstance drug = val.toEntity();
        return repository.save(drug);
    }
}
