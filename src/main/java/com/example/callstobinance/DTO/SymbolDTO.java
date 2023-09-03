package com.example.callstobinance.DTO;

public class SymbolDTO {
    private String symbol;
    private Double bidPrice;
    private Double bidQty;
    private Double askPrice;
    private Double askQty;
    private Long time;

    public SymbolDTO(String symbol, Double bidPrice, Double bidQty, Double askPrice, Double askQty, Long time) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQty = bidQty;
        this.askPrice = askPrice;
        this.askQty = askQty;
        this.time = time;
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
}
