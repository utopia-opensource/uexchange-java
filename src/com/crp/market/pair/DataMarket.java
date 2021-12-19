package com.crp.market.pair;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DataMarket
{
    public  BigDecimal  open;
    public  BigDecimal  close;
    public  BigDecimal  high;
    public  BigDecimal  low;
    public  BigDecimal  volume;
    public  BigDecimal  value;
    public  BigDecimal  volume_usd;
    public  BigDecimal  rate;
    public  long        date_now;

    public DataMarket() {}

    @JsonCreator public DataMarket(
            @JsonProperty("open")           BigDecimal  open,
            @JsonProperty("close")          BigDecimal  close,
            @JsonProperty("high")           BigDecimal  high,
            @JsonProperty("low")            BigDecimal  low,
            @JsonProperty("volume")         BigDecimal  volume,
            @JsonProperty("value")          BigDecimal  value,
            @JsonProperty("volume_usd")     BigDecimal  volume_usd,
            @JsonProperty("rate")           BigDecimal  rate,
            @JsonProperty("date_now")       long        date_now)
    {
        this.open       = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(open);
        this.close      = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(close);
        this.high       = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(high);
        this.low        = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(low);
        this.volume     = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(volume);
        this.value      = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(value);
        this.volume_usd = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(volume_usd);
        this.rate       = BigDecimal.valueOf(0.00).setScale(8, BigDecimal.ROUND_DOWN).add(rate);
        this.date_now   = date_now;
    }

    public String toString()
    { return "[open = "+open+", close = "+close+", high = "+high+", low = "+low+ ", volume = "+volume+
            ", value = "+value+", volume_usd = "+volume_usd+", rate = "+rate+ ", date_now = "+date_now+"]"; }
}
