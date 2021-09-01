package com.peterson.clinicaltrials.config;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class Utilities {

    private final Environment env;

    public String buildURL(String service) {
        return env.getProperty("api.root").concat(service).concat("?lang=en&type=json");
    }

    public HttpEntity<String> buildEntity() {

        String userKey = env.getProperty("user.key");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("user-key", userKey);
        return new HttpEntity<>("parameters", headers);
    }
}