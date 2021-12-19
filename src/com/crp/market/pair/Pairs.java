package com.crp.market.pair;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pairs
{
    public  DataMarket      data_market;
    public  Pair            pair;

    public Pairs() {}

    @JsonCreator public Pairs(
            @JsonProperty("data_market") DataMarket data_market,
            @JsonProperty("pair")        Pair       pair)
    {
        this.data_market    = data_market;
        this.pair           = pair;
    }

    public String toString()
    { return "[pair = "+pair+", data_market = "+data_market+"]"; }
}
