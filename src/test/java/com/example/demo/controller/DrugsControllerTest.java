package com.example.demo.controller;

import com.example.demo.contract.DrugContract;
import com.example.demo.services.ActingSubstancesService;
import com.example.demo.services.DrugService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class DrugsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DrugService drugService;

    @MockBean
    private ActingSubstancesService actingSubstancesService;

    private static ObjectMapper mapper = new ObjectMapper();

    static List<DrugContract> drugsStorage = new ArrayList<>();

    @Test
    void getDrugs() throws Exception {
        mockMvc.perform(get("/api/drugs")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    void getDrugById() {
    }

    @Test
    void createDrug() {
    }

    @Test
    void updateDrug() {
    }

    @Test
    void getBriefDrugs() {
    }

    @Test
    void getInteraction() {
    }
}