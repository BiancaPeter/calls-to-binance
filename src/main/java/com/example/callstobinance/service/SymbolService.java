package com.example.callstobinance.service;

import com.example.callstobinance.repository.SymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SymbolService {
    private SymbolRepository symbolRepository;

    private RestTemplate restTemplate;

    @Autowired

    public SymbolService(SymbolRepository symbolRepository, RestTemplate restTemplate) {
        this.symbolRepository = symbolRepository;
        this.restTemplate = restTemplate;
    }
}
