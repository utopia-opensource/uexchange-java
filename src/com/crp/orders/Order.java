package com.crp.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Order
{
    public int                 order_id;
    public BigDecimal          amount;
    public BigDecimal          price;
    public BigDecimal          value;
    public BigDecimal          orig_value;
    public long                date_reg;
    public String              task;
    public String              status;
    public BigDecimal          orig_amount;
    public String              cur;
    public String              ecur;
    public BigDecimal          price_executed;
    public BigDecimal          value_executed;

    public Order() {}

    @JsonCreator public Order(
            @JsonProperty("order_id")               int         order_id,
            @JsonProperty("amount")                 BigDecimal  amount,
            @JsonProperty("price")                  BigDecimal  price,
            @JsonProperty("value")                  BigDecimal  value,
            @JsonProperty("orig_value")             BigDecimal  orig_value,
            @JsonProperty("date_reg")               long        date_reg,
            @JsonProperty("task")                   String      task,
            @JsonProperty("status")                 String      status,
            @JsonProperty("orig_amount")            BigDecimal  orig_amount,
            @JsonProperty("cur")                    String      cur,
            @JsonProperty("ecur")                   String      ecur,
            @JsonProperty("price_executed")         BigDecimal  price_executed,
            @JsonProperty("value_executed")         BigDecimal  value_executed)
    {
        this.order_id       = order_id;
        this.amount         = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(amount);
        this.price          = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(price);
        this.value          = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(value);
        this.orig_value     = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(orig_value);
        this.date_reg       = date_reg;
        this.task           = task;
        this.status         = status;
        this.orig_amount    = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(orig_amount);
        this.cur            = cur;
        this.ecur           = ecur;
        this.price_executed = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(price_executed);
        this.value_executed = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(value_executed);
    }

    public String toString()
    { return "[order_id = "+order_id+", amount = "+amount+", price = "+price+", value = "+value+
            ", orig_value = "+orig_value+", date_reg = "+date_reg+", task = "+task+", status = "+status+
            ", orig_amount = "+orig_amount+", cur = "+cur+", ecur = "+ecur+", price_executed = "
            +price_executed+", value_executed = "+value_executed+"]"; }
}
