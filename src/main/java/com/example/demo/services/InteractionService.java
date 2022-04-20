package com.example.demo.services;

import com.example.demo.contract.InteractionContract;
import com.example.demo.model.entities.Effect;
import com.example.demo.model.entities.Interaction;
import com.example.demo.repositories.InteractionRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

@Service
public class InteractionService implements IInteractionService {
    @Autowired
    InteractionRepository repository;

    @Autowired
    IActingSubstancesService actingSubstanceService;

    @Override
    public Interaction updateOrCreate(InteractionContract contract) {
        Interaction interaction =
                repository.findById(Optional.ofNullable(contract.getId()).orElse(-1L)).orElseGet(Interaction::new);

        Util.assignIfNotNull(contract::getClinical_consequence, interaction::setClinical_consequence);
        Util.assignIfNotNull(contract::getKind_of_interaction, interaction::setKind_of_interaction);

        Util.assignIfNotNull(contract::getActing_substance, (actingSubstanceContract -> {
            var actingSubstance = actingSubstanceService.updateOrCreate(actingSubstanceContract);
            if (!interaction.getActingSubstance().getId().equals(actingSubstance.getId())) {
                interaction.setActingSubstance(actingSubstance);
            }
        }));

        return interaction;
    }
}
