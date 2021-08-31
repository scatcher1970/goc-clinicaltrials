package com.peterson.clinicaltrials.controllers;

import com.peterson.clinicaltrials.domain.*;
import com.peterson.clinicaltrials.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final DrugProductRepository drugProductRepository;
    private final ProtocolRepository protocolRepository;
    private final StudyPopulationRepository studyPopulationRepository;
    private final SponsorRepository sponsorRepository;
    private final StatusRepository statusRepository;
    private final MedicalConditionRepository medicalConditionRepository;

    @GetMapping("/drugproducts")
    public String showDrugProducts(Model model) {
        ArrayList<DrugProduct> drugProducts = drugProductRepository.getArray();

        model.addAttribute("drugProducts", drugProducts);
        return ("drugProducts");
    }

    @GetMapping("/protocols")
    public String showProtocols(Model model) {
        ArrayList<Protocol> protocols = protocolRepository.getArray();

        model.addAttribute("protocols", protocols);
        return ("protocols");
    }

    @GetMapping("/studypopulations")
    public String showPopulations(Model model) {
        ArrayList<StudyPopulation> studyPopulations = studyPopulationRepository.getArray();

        model.addAttribute("studyPopulations", studyPopulations);
        return ("studyPopulations");
    }

    @GetMapping("/sponsors")
    public String showSponsors(Model model) {
        ArrayList<Sponsor> sponsors = sponsorRepository.getArray();

        model.addAttribute("sponsors", sponsors);
        return ("sponsors");
    }

    @GetMapping("/statuses")
    public String showStatuses(Model model) {
        ArrayList<Status> statuses = statusRepository.getArray();

        model.addAttribute("statuses", statuses);
        return ("statuses");
    }

    @GetMapping("/medicalconditions")
    public String showMedicalConditions(Model model) {
        ArrayList<MedicalCondition> medicalConditions = medicalConditionRepository.getArray();

        model.addAttribute("medicalConditions", medicalConditions);
        return ("medicalConditions");
    }
}
