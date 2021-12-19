package com.crp.orders;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;

public class OrderHistory
{
    public Order               order;
    public LinkedList<String>  history;
    public PairStr             pair;

    public OrderHistory() {}

    @JsonCreator public OrderHistory(
            @JsonProperty("order")      Order               order,
            @JsonProperty("history")    LinkedList<String>  history,
            @JsonProperty("pair")       PairStr             pair)
    {
        this.order     = order;
        this.history   = history;
        this.pair      = pair;
    }

    public String toString()
    { return "[order = "+order+", history = "+history+", pair = "+pair+"]";}
}
