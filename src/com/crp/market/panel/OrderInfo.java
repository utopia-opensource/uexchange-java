package com.crp.market.panel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OrderInfo
{
    public  BigDecimal  price;
    public  BigDecimal  amount;
    public  BigDecimal  value;

    public OrderInfo() {}

    @JsonCreator public OrderInfo(
            @JsonProperty("price")  BigDecimal price,
            @JsonProperty("amount") BigDecimal amount,
            @JsonProperty("value")  BigDecimal value)
    {
        this.price   = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(price);
        this.amount  = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(amount);
        this.value   = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(value);
    }

    public String toString()
    { return "[price = "+price+", amount = "+amount+", value = "+value+"]"; }
}
