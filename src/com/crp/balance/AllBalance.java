package com.crp.balance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.LinkedList;

public class AllBalance
{
    public  LinkedList<Balance> allbalance;
    public  String              user_id;

    public AllBalance() {}

    @JsonCreator public AllBalance(
            @JsonProperty("allbalance")   LinkedList<Balance> allbalance,
            @JsonProperty("user_id")      String user_id)
    {
        this.allbalance = allbalance;
        this.user_id    = user_id;
    }

    public String toString()
    { return "[allbalance = "+ Arrays.toString(allbalance.toArray()) +", user_id = "+user_id+"]"; }
}
