package com.crp.market;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderResponse
{
    public boolean     success;
    public int         order_id;
    public int         daemon_id;

    public OrderResponse() {}

    @JsonCreator public OrderResponse(
            @JsonProperty("success")    boolean success,
            @JsonProperty("order_id")   int     order_id,
            @JsonProperty("daemon_id")  int     daemon_id)
    {
        this.success    = success;
        this.order_id   = order_id;
        this.daemon_id  = daemon_id;
    }

    public String toString()
    { return "[success = "+success+", order_id = "+order_id+", daemon_id = "+daemon_id+"]"; }
}
