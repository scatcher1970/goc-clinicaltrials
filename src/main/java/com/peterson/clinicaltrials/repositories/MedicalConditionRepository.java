package com.peterson.clinicaltrials.repositories;

import com.peterson.clinicaltrials.abstracts.JsonRepository;
import com.peterson.clinicaltrials.config.Utilities;
import com.peterson.clinicaltrials.domain.DrugProduct;
import com.peterson.clinicaltrials.domain.MedicalCondition;
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
public class MedicalConditionRepository extends JsonRepository {

    private final Utilities utilities;

    private MedicalCondition[] medicalConditions;

    public ArrayList<MedicalCondition> getArray() {

        this.getObjects();

        ArrayList<MedicalCondition> medicalConditionArrayList = new ArrayList<>(List.of(this.medicalConditions));
        Collections.sort(medicalConditionArrayList);
        return medicalConditionArrayList;
    }

    protected void performFetch() {

        String serviceUrl = utilities.buildURL("medicalcondition");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = utilities.buildEntity();
        ResponseEntity<MedicalCondition[]> respEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, MedicalCondition[].class);
        this.medicalConditions = respEntity.getBody();

        if (this.medicalConditions == null) {
            this.medicalConditions = new MedicalCondition[0];
        }
    }
}
