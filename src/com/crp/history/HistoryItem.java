package com.crp.history;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class HistoryItem
{
    public String              record_type;
    public int                 order_id;
    public String              order_user;
    public BigDecimal          price;
    public BigDecimal          amount;
    public BigDecimal          value;
    public String              cur;
    public String              ecur;
    public String              pair;
    public String              val;
    public BigDecimal          val_balance;
    public BigDecimal          fee;
    public long                created_at;

    public HistoryItem() {}

    @JsonCreator public HistoryItem(
            @JsonProperty("record_type")        String      record_type,
            @JsonProperty("order_id")           int         order_id,
            @JsonProperty("order_user")         String      order_user,
            @JsonProperty("price")              BigDecimal  price,
            @JsonProperty("amount")             BigDecimal  amount,
            @JsonProperty("value")              BigDecimal  value,
            @JsonProperty("cur")                String      cur,
            @JsonProperty("ecur")               String      ecur,
            @JsonProperty("pair")               String      pair,
            @JsonProperty("val")                String      val,
            @JsonProperty("val_balance")        BigDecimal  val_balance,
            @JsonProperty("fee")                BigDecimal  fee,
            @JsonProperty("created_at")         long        created_at)
    {
        this.record_type    = record_type;
        this.order_id       = order_id;
        this.order_user     = order_user;
        this.price          = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(price);
        this.amount         = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(amount);
        this.value          = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(value);
        this.cur            = cur;
        this.ecur           = ecur;
        this.pair           = pair;
        this.val            = val;
        this.val_balance    = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(val_balance);
        this.fee            = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(fee);
        this.created_at     = created_at;
    }

    public String toString()
    { return "[record_type = "+record_type+", order_id = "+order_id+", order_user = "+order_user+
            ", price = "+price+", amount = "+amount+", value = "+value+ ", cur = "+cur+
            ", ecur = "+ecur+", pair = "+pair+", val = "+val+", val_balance = "+val_balance+
            ", fee = "+fee+", created_at = "+created_at+"]"; }
}
