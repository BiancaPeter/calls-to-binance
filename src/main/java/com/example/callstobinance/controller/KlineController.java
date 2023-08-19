package com.example.callstobinance.controller;

import com.example.callstobinance.service.KlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KlineController {
    private KlineService klineService;

    @Autowired
    public KlineController(KlineService klineService) {
        this.klineService = klineService;
    }
}
