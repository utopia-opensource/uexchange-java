package com.crp.balance;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Currency
{
    public int          id;
    public String       name;
    public String       fullname;
    public String       appname;
    public String       icon;
    public int          round;
    public BigDecimal   deposit_fee;
    public BigDecimal   deposit_min;
    public BigDecimal   withdraw_fee;
    public BigDecimal   withdraw_fee_pro;
    public BigDecimal   withdraw_min;
    public int          address_size;
    public BigDecimal   min_fee;
    public boolean      enable;
    public boolean      show;

    public Currency() {}

    @JsonCreator public Currency(
            @JsonProperty("id")                 int         id,
            @JsonProperty("name")               String      name,
            @JsonProperty("fullname")           String      fullname,
            @JsonProperty("appname")            String      appname,
            @JsonProperty("icon")               String      icon,
            @JsonProperty("round")              int         round,
            @JsonProperty("deposit_fee")        BigDecimal  deposit_fee,
            @JsonProperty("deposit_min")        BigDecimal  deposit_min,
            @JsonProperty("withdraw_fee")       BigDecimal  withdraw_fee,
            @JsonProperty("withdraw_fee_pro")   BigDecimal  withdraw_fee_pro,
            @JsonProperty("withdraw_min")       BigDecimal  withdraw_min,
            @JsonProperty("address_size")       int         address_size,
            @JsonProperty("min_fee")            BigDecimal  min_fee,
            @JsonProperty("enable")             boolean     enable,
            @JsonProperty("show")               boolean     show)
    {
        this.id                 = id;
        this.name               = name;
        this.fullname           = fullname;
        this.appname            = appname;
        this.icon               = icon;
        this.round              = round;
        this.deposit_fee        = BigDecimal.valueOf(0.00).setScale(round, BigDecimal.ROUND_DOWN).add(deposit_fee);
        this.deposit_min        = BigDecimal.valueOf(0.00).setScale(round, BigDecimal.ROUND_DOWN).add(deposit_min);
        this.withdraw_fee       = BigDecimal.valueOf(0.00).setScale(round, BigDecimal.ROUND_DOWN).add(withdraw_fee);
        this.withdraw_fee_pro   = BigDecimal.valueOf(0.00).setScale(round, BigDecimal.ROUND_DOWN).add(withdraw_fee_pro);
        this.withdraw_min       = BigDecimal.valueOf(0.00).setScale(round, BigDecimal.ROUND_DOWN).add(withdraw_min);
        this.address_size       = address_size;
        this.min_fee            = BigDecimal.valueOf(0.00).setScale(round, BigDecimal.ROUND_DOWN).add(min_fee);
        this.enable             = enable;
        this.show               = show;
    }

    public String toString()
    { return "[id = "+id+", name = "+name+", fullname = "+fullname+", appname = "+appname+
            ", icon = "+icon+", round = "+round+", deposit_fee = "+deposit_fee+", deposit_min = "+deposit_min+
            ", withdraw_fee = "+withdraw_fee+", withdraw_fee_pro = "+withdraw_fee_pro+", withdraw_min = "+withdraw_min+
            ", deposit_min = "+deposit_min+", address_size = "+address_size+", min_fee = "+min_fee+", enable = "+enable+
            ", show = "+show+"]"; }
}
