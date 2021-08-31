package com.peterson.clinicaltrials.repositories;

import com.peterson.clinicaltrials.abstracts.JsonRepository;
import com.peterson.clinicaltrials.config.Utilities;
import com.peterson.clinicaltrials.domain.StudyPopulation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Component
@Scope("singleton")
public class StudyPopulationRepository extends JsonRepository {

    private final Utilities utilities;

    private StudyPopulation[] studyPopulations;

    public ArrayList<StudyPopulation> getArray() {

        this.getObjects();

        ArrayList<StudyPopulation> studyPopulationArrayList = new ArrayList<>(List.of(studyPopulations));
        Collections.sort(studyPopulationArrayList);
        return studyPopulationArrayList;
    }

    protected void performFetch() {

        String serviceUrl = utilities.buildURL("studypopulation");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = utilities.buildEntity();
        ResponseEntity<StudyPopulation[]> respEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, StudyPopulation[].class);
        this.studyPopulations = respEntity.getBody();

        if (this.studyPopulations == null) {
            this.studyPopulations = new StudyPopulation[0];
        }
    }
}
