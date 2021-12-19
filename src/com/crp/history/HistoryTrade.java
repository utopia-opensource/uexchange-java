package com.crp.history;

import com.crp.orders.PairStr;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.LinkedList;

public class HistoryTrade
{
    public LinkedList<HistoryTradeItem>    items;
    public PairStr                         pair;

    public HistoryTrade() {}

    @JsonCreator public HistoryTrade(
            @JsonProperty("items")   LinkedList<HistoryTradeItem>   items,
            @JsonProperty("pair")    PairStr                        pair)
    {
        this.items  = items;
        this.pair   = pair;
    }

    public String toString()
    { return "Pojo [pair = "+pair+", items = "+ Arrays.toString(items.toArray()) +"]";}
}
