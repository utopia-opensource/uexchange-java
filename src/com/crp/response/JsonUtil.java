package com.crp.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil
{
    public static <T> T convertJsonToObject(final TypeReference<T> type, final String jsonPacket)
    {
        T data = null;
        try
        { data = new ObjectMapper().readValue(jsonPacket, type); }
        catch (Exception e)
        { e.printStackTrace(); }

        return data;
    }

    public static <T> T convertJsonToObject(T object, String jsonString)
    {
        ObjectMapper mapper = new ObjectMapper();
        T obj               = null;
        try
        { obj               = (T) mapper.readValue(jsonString, object.getClass()); }
        catch (JsonProcessingException e)
        { e.printStackTrace(); }

        return obj;
    }
}
