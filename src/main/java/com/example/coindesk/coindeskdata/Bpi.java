package com.example.coindesk.coindeskdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bpi {
    @JsonProperty("USD")
    CoinPrice usd;
    @JsonProperty("GBP")
    CoinPrice gbp;
    @JsonProperty("EUR")
    CoinPrice eur;

    public CoinPrice getUsd() {
        return usd;
    }

    public void setUsd(CoinPrice usd) {
        this.usd = usd;
    }

    public CoinPrice getGbp() {
        return gbp;
    }

    public void setGbp(CoinPrice gbp) {
        this.gbp = gbp;
    }

    public CoinPrice getEur() {
        return eur;
    }

    public void setEur(CoinPrice eur) {
        this.eur = eur;
    }
}
