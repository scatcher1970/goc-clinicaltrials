package com.peterson.clinicaltrials.repositories;

import com.peterson.clinicaltrials.abstracts.JsonRepository;
import com.peterson.clinicaltrials.config.Utilities;
import com.peterson.clinicaltrials.domain.Sponsor;
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
public class SponsorRepository extends JsonRepository {

    private final Utilities utilities;

    private Sponsor[] sponsors;

    public ArrayList<Sponsor> getArray() {

        this.getObjects();

        ArrayList<Sponsor> sponsorArrayList = new ArrayList<>(List.of(this.sponsors));
        Collections.sort(sponsorArrayList);
        return sponsorArrayList;
    }

    protected void performFetch() {

        String serviceUrl = utilities.buildURL("sponsor");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = utilities.buildEntity();
        ResponseEntity<Sponsor[]> respEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, Sponsor[].class);
        this.sponsors = respEntity.getBody();

        if (this.sponsors == null) {
            this.sponsors = new Sponsor[0];
        }
    }
}
