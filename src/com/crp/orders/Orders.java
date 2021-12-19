package com.crp.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;

public class Orders
{
    public LinkedList<String> allorders                                  = new LinkedList<String>();
    public Paginator          paginator;
    public LinkedList<String> filters                                    = new LinkedList<String>();
    public int                my_order_count;

    public Orders() {}

    @JsonCreator public Orders(
            @JsonProperty("allorders")      LinkedList<String>  allorders,
            @JsonProperty("paginator")      Paginator           paginator,
            @JsonProperty("filters")        LinkedList<String>  filters,
            @JsonProperty("my_order_count") int                 my_order_count)
    {
        this.allorders         = allorders;
        this.paginator         = paginator;
        this.filters           = filters;
        this.my_order_count    = my_order_count;
    }

    public String toString()
    { return "[allorders = "+allorders+", paginator = "+paginator+", filters = "+filters+", my_order_count = "+my_order_count+"]"; }
}
