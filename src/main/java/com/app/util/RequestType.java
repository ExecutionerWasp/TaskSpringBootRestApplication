package com.app.util;

import com.app.domain.Currency;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Alvin
 **/
@Log4j2
@Getter
@RequiredArgsConstructor
public enum RequestType implements Serializable {
    MONO_BANK("https://api.monobank.ua/bank/currency");

    @NonNull
    private String url;

    public String getJson() {
        log.info("Connecting to mono bank...");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(this.url, String.class);
        log.info("Response json from mono bank : \n" + response);
        return response;
    }
}
