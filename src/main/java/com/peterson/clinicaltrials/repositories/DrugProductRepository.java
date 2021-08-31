package com.peterson.clinicaltrials.repositories;

import com.peterson.clinicaltrials.abstracts.JsonRepository;
import com.peterson.clinicaltrials.config.Utilities;
import com.peterson.clinicaltrials.domain.DrugProduct;
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
public class DrugProductRepository extends JsonRepository {

    private final Utilities utilities;

    private DrugProduct[] drugProducts;

    public ArrayList<DrugProduct> getArray() {

        this.getObjects();

        ArrayList<DrugProduct> drugProductArrayList = new ArrayList<>(List.of(drugProducts));
        Collections.sort(drugProductArrayList);
        return drugProductArrayList;
    }

    protected void performFetch() {

        String serviceUrl = utilities.buildURL("drugproduct");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = utilities.buildEntity();
        ResponseEntity<DrugProduct[]> respEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, DrugProduct[].class);
        this.drugProducts = respEntity.getBody();

        if (this.drugProducts == null) {
            this.drugProducts = new DrugProduct[0];
        }
    }
}
