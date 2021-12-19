package com.crp.market.pair;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Pair
{
    public int         pair_id;
    public String      pair;
    public String      pair_show;
    public String      group;
    public boolean     visible;
    public boolean     enable;
    public int         round_deal_amount;
    public int         round_deal_price;
    public  BigDecimal min_amount;
    public  BigDecimal min_price;
    public  BigDecimal max_price;

    public Pair() {}

    @JsonCreator public Pair(
            @JsonProperty("pair_id")            int         pair_id,
            @JsonProperty("pair")               String      pair,
            @JsonProperty("pair_show")          String      pair_show,
            @JsonProperty("group")              String      group,
            @JsonProperty("visible")            boolean     visible,
            @JsonProperty("enable")             boolean     enable,
            @JsonProperty("round_deal_amount")  int         round_deal_amount,
            @JsonProperty("round_deal_price")   int         round_deal_price,
            @JsonProperty("min_amount")         BigDecimal  min_amount,
            @JsonProperty("min_price")          BigDecimal  min_price,
            @JsonProperty("max_price")          BigDecimal  max_price)
    {
        this.pair_id            = pair_id;
        this.pair               = pair;
        this.pair_show          = pair_show;
        this.group              = group;
        this.visible            = visible;
        this.enable             = enable;
        this.round_deal_amount  = round_deal_amount;
        this.round_deal_price   = round_deal_price;
        this.min_amount         = BigDecimal.valueOf(0.00).setScale(round_deal_amount, BigDecimal.ROUND_DOWN).add(min_amount);
        this.min_price          = BigDecimal.valueOf(0.00).setScale(round_deal_price, BigDecimal.ROUND_DOWN).add(min_price);
        this.max_price          = BigDecimal.valueOf(0.00).setScale(round_deal_price, BigDecimal.ROUND_DOWN).add(max_price);
    }

    public String toString()
    { return "[pair_id = "+pair_id+", pair = "+pair+", pair_show = "+pair_show+", group = "+group+
            ", visible = "+visible+", enable = "+enable+", round_deal_amount = "+round_deal_amount+", round_deal_price = "+round_deal_price+
            ", min_amount = "+min_amount+", min_price = "+min_price+", max_price = "+max_price+"]"; }
}
