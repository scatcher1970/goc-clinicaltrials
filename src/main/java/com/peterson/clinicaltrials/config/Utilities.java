package com.peterson.clinicaltrials.config;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

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
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return entity;
    }
}