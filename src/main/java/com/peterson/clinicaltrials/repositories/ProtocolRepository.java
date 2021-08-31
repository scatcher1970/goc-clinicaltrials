package com.peterson.clinicaltrials.repositories;

import com.peterson.clinicaltrials.abstracts.JsonRepository;
import com.peterson.clinicaltrials.config.Utilities;
import com.peterson.clinicaltrials.domain.Protocol;
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
public class ProtocolRepository extends JsonRepository {

    private final Utilities utilities;

    private Protocol[] protocols;

    public ArrayList<Protocol> getArray() {

        this.getObjects();

        ArrayList<Protocol> protocolArrayList = new ArrayList<>(List.of(protocols));
        Collections.sort(protocolArrayList);
        return protocolArrayList;
    }

    protected void performFetch() {

        String serviceUrl = utilities.buildURL("protocol");

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = utilities.buildEntity();
        ResponseEntity<Protocol[]> respEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, Protocol[].class);
        this.protocols = respEntity.getBody();

        if (this.protocols == null) {
            this.protocols = new Protocol[0];
        }
    }
}
