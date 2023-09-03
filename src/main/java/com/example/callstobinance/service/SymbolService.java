package com.example.callstobinance.service;

import com.example.callstobinance.DTO.SymbolDTO;
import com.example.callstobinance.model.Symbol;
import com.example.callstobinance.repository.SymbolRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SymbolService {
    private SymbolRepository symbolRepository;

    private RestTemplate restTemplate;


    private static final String ALL_SYMBOLS_URL = "https://testnet.binancefuture.com/fapi/v1/ticker/bookTicker";

    @Autowired
    public SymbolService(SymbolRepository symbolRepository, RestTemplate restTemplate) {
        this.symbolRepository = symbolRepository;
        this.restTemplate = restTemplate;
    }

    public void addAllSymbols() throws JsonProcessingException, URISyntaxException {
        JsonNode root = getResponseBodyJson(ALL_SYMBOLS_URL);
        ArrayNode symbolsListJson = (ArrayNode) root;
        for (JsonNode symbolJson : symbolsListJson) {
            convertFromJsonToSymbol(symbolJson);
        }
    }

    public JsonNode getResponseBodyJson(String requestBaseUrl) throws JsonProcessingException, URISyntaxException {
        URI url = new URI(requestBaseUrl);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(response.getBody());
    }

    public Symbol convertFromJsonToSymbol(JsonNode node) {
        Symbol symbolToBeAdd = new Symbol();
        symbolToBeAdd.setSymbol(node.path("symbol").asText());
        symbolToBeAdd.setBidPrice(node.path("bidPrice").asDouble());
        symbolToBeAdd.setBidQty(node.path("bidQty").asDouble());
        symbolToBeAdd.setAskPrice(node.path("askPrice").asDouble());
        symbolToBeAdd.setAskQty(node.path("askQty").asDouble());
        symbolToBeAdd.setTime(node.path("time").asLong());
        return symbolRepository.save(symbolToBeAdd);
    }

    public List<SymbolDTO> getAllSymbols() {
        List<SymbolDTO> symbolsDTO = new ArrayList<>();
        List<Symbol> symbols = symbolRepository.findAll();
        for (Symbol symbol:symbols) {
            SymbolDTO newSymbolDTO = new SymbolDTO(symbol.getSymbol(), symbol.getBidPrice(), symbol.getBidQty(), symbol.getAskPrice(), symbol.getAskQty(), symbol.getTime());
            symbolsDTO.add(newSymbolDTO);
        }
        return symbolsDTO;
    }

}
