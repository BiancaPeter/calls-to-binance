package com.example.callstobinance.service;

import com.example.callstobinance.model.Kline;
import com.example.callstobinance.model.Symbol;
import com.example.callstobinance.repository.KlineRepository;
import com.example.callstobinance.repository.SymbolRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class KlineService {
    private KlineRepository klineRepository;

    private SymbolRepository symbolRepository;

    private RestTemplate restTemplate;


    private static final String KLINE_URL = "https://api.binance.com/api/v3/klines?symbol={symbol}&interval={interval}&limit={limit}";

    @Autowired
    public KlineService(KlineRepository klineRepository, SymbolRepository symbolRepository, RestTemplate restTemplate) {
        this.klineRepository = klineRepository;
        this.symbolRepository = symbolRepository;
        this.restTemplate = restTemplate;
    }

    public void addKline(String symbol, String interval, String limit) throws JsonProcessingException {
        JsonNode responseBodyJson = getResponseBodyJson(KLINE_URL, symbol, interval, limit);
        for (int i = 0; i < Integer.parseInt(limit); i++) {
            addAKline(responseBodyJson, i, symbol);
        }
    }

    public JsonNode getResponseBodyJson(String requestBaseUrl, String symbol, String interval, String limit) throws JsonProcessingException {
        URI url = new UriTemplate(requestBaseUrl).expand(symbol, interval, limit);
        return makeAPICall(url);
    }

    private JsonNode makeAPICall(URI url) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(response.getBody());
    }

    private Kline addAKline(JsonNode responseBodyJson, int i, String symbolName) {
        Kline newKline = new Kline();
        JsonNode result = responseBodyJson.get(i);
        newKline.setOpenTime(result.get(0).asLong());
        newKline.setOpen(result.get(1).asText());
        newKline.setHigh(result.get(2).asText());
        newKline.setLow(result.get(3).asText());
        newKline.setClose(result.get(4).asText());
        newKline.setVolume(result.get(5).asText());
        newKline.setCloseTime(result.get(6).asLong());
        newKline.setQuoteAssetVolume(result.get(7).asText());
        newKline.setNumberOfTraders(result.get(8).asLong());
        newKline.setTakerBuyBaseAssetVolume(result.get(9).asText());
        newKline.setTakerBuyQuoteAssetVolume(result.get(10).asText());
        newKline.setIgnoree(result.get(10).asText());

        Symbol foundSymbol = symbolRepository.findBySymbol(symbolName);
        newKline.setSymbol(foundSymbol);

        return klineRepository.save(newKline);
    }

}
