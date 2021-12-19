package com.crp.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Paginator
{
    public int                count;
    public int                page;
    public int                limit;

    public Paginator() {}

    @JsonCreator public Paginator(
            @JsonProperty("count")              int count,
            @JsonProperty("page")               int page,
            @JsonProperty("limit")              int limit)
    {
        this.count      = count;
        this.page       = page;
        this.limit      = limit;
    }

    public String toString()
    { return "[count = "+count+", page = "+page+", limit = "+limit+"]"; }
}
