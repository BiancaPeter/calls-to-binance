package com.example.callstobinance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Kline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq",
            sequenceName = "category_seq",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column
    private Long openTime;

    @Column
    private String open;

    @Column
    private String high;

    @Column
    private String low;

    @Column
    private String close;

    @Column
    private String volume;

    @Column
    private Long closeTime;

    @Column
    private String quoteAssetVolume;

    @Column
    private Long numberOfTraders;

    @Column
    private String takerBuyBaseAssetVolume;

    @Column
    private String takerBuyQuoteAssetVolume;

    @Column
    private String ignoree;

    @ManyToOne
    @JsonBackReference(value = "symbol-kline")
    @JoinColumn(name = "symbol_Id")
    private Symbol symbol;

    public Kline() {
    }

    public Kline(Long id, Long openTime, String open, String high, String low, String close, String volume, Long closeTime, String quoteAssetVolume, Long numberOfTraders, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume, String ignoree, Symbol symbol) {
        this.id = id;
        this.openTime = openTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTraders = numberOfTraders;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
        this.ignoree = ignoree;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getQuoteAssetVolume() {
        return quoteAssetVolume;
    }

    public void setQuoteAssetVolume(String quoteAssetVolume) {
        this.quoteAssetVolume = quoteAssetVolume;
    }

    public Long getNumberOfTraders() {
        return numberOfTraders;
    }

    public void setNumberOfTraders(Long numberOfTraders) {
        this.numberOfTraders = numberOfTraders;
    }

    public String getTakerBuyBaseAssetVolume() {
        return takerBuyBaseAssetVolume;
    }

    public void setTakerBuyBaseAssetVolume(String takerBuyBaseAssetVolume) {
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
    }

    public String getTakerBuyQuoteAssetVolume() {
        return takerBuyQuoteAssetVolume;
    }

    public void setTakerBuyQuoteAssetVolume(String takerBuyQuoteAssetVolume) {
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

    public String getIgnoree() {
        return ignoree;
    }

    public void setIgnoree(String ignoree) {
        this.ignoree = ignoree;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
