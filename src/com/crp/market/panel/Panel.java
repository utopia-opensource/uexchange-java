package com.crp.market.panel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedList;

public class Panel
{
    public LinkedList<OrderInfo>   book_sell;
    public LinkedList<OrderInfo>   book_buy;
    public Volumes                 volumes;
    public long                    time;
    public String                  cur;
    public String                  ecur;
    public String                  pair;

    public Panel() {}

    @JsonCreator public Panel(
            @JsonProperty("book_sell")          LinkedList<OrderInfo> book_sell,
            @JsonProperty("book_buy")           LinkedList<OrderInfo> book_buy,
            @JsonProperty("volumes")            Volumes               volumes,
            @JsonProperty("time")               long                  time,
            @JsonProperty("cur")                String                cur,
            @JsonProperty("ecur")               String                ecur,
            @JsonProperty("pair")               String                pair)
    {
        this.book_sell  = book_sell;
        this.book_buy   = book_buy;
        this.volumes    = volumes;
        this.time       = time;
        this.cur        = cur;
        this.ecur       = ecur;
        this.pair       = pair;
    }

    public String toString()
    { return "[book_sell = "+book_sell+", book_buy = "+book_buy+", volumes = "+volumes+", time = "+time+
            ", cur = "+cur+", ecur = "+ecur+", pair = "+pair+"]"; }
}
