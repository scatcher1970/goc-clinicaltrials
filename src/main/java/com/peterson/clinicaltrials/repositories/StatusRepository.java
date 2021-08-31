package com.peterson.clinicaltrials.repositories;

import com.peterson.clinicaltrials.abstracts.JsonRepository;
import com.peterson.clinicaltrials.config.Utilities;
import com.peterson.clinicaltrials.domain.Status;
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
public class StatusRepository extends JsonRepository {

    private final Utilities utilities;

    private Status[] statuses;

    public ArrayList<Status> getArray() {

        this.getObjects();

        ArrayList<Status> statusesArrayList = new ArrayList<>(List.of(this.statuses));
        Collections.sort(statusesArrayList);
        return statusesArrayList;
    }

    protected void performFetch() {

        String serviceUrl = utilities.buildURL("status");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = utilities.buildEntity();
        ResponseEntity<Status[]> respEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, Status[].class);
        this.statuses = respEntity.getBody();

        if (this.statuses == null) {
            this.statuses = new Status[0];
        }
    }
}
