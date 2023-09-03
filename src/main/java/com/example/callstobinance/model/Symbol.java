package com.example.callstobinance.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq",
            sequenceName = "category_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column
    private String symbol;

    @Column
    private Double bidPrice;

    @Column
    private Double bidQty;

    @Column
    private Double askPrice;

    @Column
    private Double askQty;

    @Column
    private Long time;

    @OneToMany(mappedBy = "symbol", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "symbol-kline")
    private List<Kline> klineList;

    public Symbol() {
    }

    public Symbol(Long id, String symbol, Double bidPrice, Double bidQty, Double askPrice, Double askQty, Long time, List<Kline> klineList) {
        this.id = id;
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.time = time;
        this.klineList = klineList;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getBidQty() {
        return bidQty;
    }

    public void setBidQty(Double bidQty) {
        this.bidQty = bidQty;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public Double getAskQty() {
        return askQty;
    }

    public void setAskQty(Double askQty) {
        this.askQty = askQty;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public List<Kline> getKlineList() {
        if (this.klineList == null) {
            this.klineList = new ArrayList<>();
        }
        return klineList;
    }

    public void setKlineList(List<Kline> klineList) {
        this.klineList = klineList;
    }
}
