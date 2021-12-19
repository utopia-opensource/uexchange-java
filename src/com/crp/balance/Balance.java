package com.crp.balance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Balance
{
    public  int         id;
    public  Currency    currency;
    public  BigDecimal  reserve;
    public  BigDecimal  balance;

    public Balance() {}

    @JsonCreator public Balance(
            @JsonProperty("id")                 int         id,
            @JsonProperty("currency")           Currency    currency,
            @JsonProperty("reserve")            BigDecimal  reserve,
            @JsonProperty("balance")            BigDecimal  balance)
    {
        this.id            = id;
        this.currency      = currency;
        this.reserve       = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(reserve);
        this.balance       = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(balance);
    }

    public String toString()
    { return "[id = "+id+", currency = "+currency+", reserve = "+reserve+", balance = "+balance+"]"; }
}
