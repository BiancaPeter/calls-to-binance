package com.example.callstobinance.service;

import com.example.callstobinance.repository.KlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlineService {
    private KlineRepository klineRepository;

    @Autowired
    public KlineService(KlineRepository klineRepository) {
        this.klineRepository = klineRepository;
    }
}
