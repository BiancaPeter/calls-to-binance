package com.example.callstobinance.controller;

import com.example.callstobinance.service.KlineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binance")
public class KlineController {
    private KlineService klineService;

    @Autowired
    public KlineController(KlineService klineService) {
        this.klineService = klineService;
    }

    @PostMapping("/addKline/{symbol}/{interval}/{limit}")
    public void addKline(@PathVariable("symbol") String symbol, @PathVariable("interval") String interval, @PathVariable("limit") String limit) throws JsonProcessingException {
        klineService.addKline(symbol, interval, limit);
    }
}
