package com.crp.orders;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PairStr
{
    public String              cur;
    public String              ecur;

    public PairStr() {}

    @JsonCreator public PairStr(
            @JsonProperty("cur")    String cur,
            @JsonProperty("ecur")   String ecur)
    {
        this.cur       = cur;
        this.ecur      = ecur;
    }

    public String toString()
    { return "[cur = "+cur+", ecur = "+ecur+"]";}
}
