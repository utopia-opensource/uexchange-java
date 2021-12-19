package com.crp.history;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class HistoryTradeItem
{
    public String              record_id;
    public String              record_type;
    public BigDecimal          price;
    public BigDecimal          amount;
    public BigDecimal          value;
    public long                created_at;

    public HistoryTradeItem() {}

    @JsonCreator public HistoryTradeItem(
            @JsonProperty("record_id")         String      record_id,
            @JsonProperty("record_type")       String      record_type,
            @JsonProperty("price")             BigDecimal  price,
            @JsonProperty("amount")            BigDecimal  amount,
            @JsonProperty("value")             BigDecimal  value,
            @JsonProperty("created_at")        long        created_at)
    {
        this.record_id      = record_id;
        this.record_type    = record_type;
        this.price          = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(price);
        this.amount         = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(amount);
        this.value          = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(value);
        this.created_at     = created_at;
    }

    public String toString()
    { return "[record_id = "+record_id+", record_type = "+record_type+", price = "+price+
            ", amount = "+amount+", value = "+value+"]"; }
}
