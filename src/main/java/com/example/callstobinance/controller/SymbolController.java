package com.example.callstobinance.controller;

import com.example.callstobinance.DTO.SymbolDTO;
import com.example.callstobinance.service.SymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/binance")
public class SymbolController {
    private SymbolService symbolService;

    @Autowired
    public SymbolController(SymbolService symbolService) {
        this.symbolService = symbolService;
    }

    @PostMapping("/addSymbols")
    public void addAllSymbols() throws URISyntaxException, JsonProcessingException {
        symbolService.addAllSymbols();
    }

    @GetMapping("/getSymbols")
    public ResponseEntity<List<SymbolDTO>> getAllSymbols() {
        return status(HttpStatus.OK).body(symbolService.getAllSymbols());
    }
}
