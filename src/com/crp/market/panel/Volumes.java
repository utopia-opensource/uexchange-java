package com.crp.market.panel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Volumes
{
    public  BigDecimal  sell;
    public  BigDecimal  buy;

    public Volumes() {}

    @JsonCreator public Volumes(
            @JsonProperty("sell")   BigDecimal sell,
            @JsonProperty("buy")    BigDecimal buy)
    {
        this.sell  = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(sell);
        this.buy   = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(buy);
    }

    public String toString()
    { return "[sell = "+sell+", buy = "+buy+"]"; }
}
