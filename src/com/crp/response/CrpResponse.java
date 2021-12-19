package com.crp.response;

import com.sun.istack.internal.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CrpResponse
{
    public static final String MAIN_URL = "https://crp.is:8182/";

    public  boolean     success;
    public  String      result;

    private String      m_FullResponse;
    public  String      getFullResponse()               { return m_FullResponse; }

    public CrpResponse() { }

    @Nullable
    public CrpResponse getResponse(String data, String method, String cookie) throws CrpResponseException
    {
        success                     = false;

        try
        {
            HttpURLConnection conn  = (HttpURLConnection)(new URL(MAIN_URL+data)).openConnection();
            conn.setDoOutput(true);
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64)");
            conn.setRequestMethod(method);
            if (!cookie.isEmpty()) conn.setRequestProperty("Cookie", cookie);
            conn.connect();
            conn.setConnectTimeout(5000);

            InputStream     is      = conn.getInputStream();
            BufferedReader  reader  = new BufferedReader(new InputStreamReader(is));
            String          line    = null;
            StringBuffer    sb      = new StringBuffer();
            while((line = reader.readLine()) != null) sb.append(line);

            is.close(); conn.disconnect(); reader.close();
            String response         = sb.toString();
            JSONObject obj          = new JSONObject(response);
            m_FullResponse          = response;
            success               = obj.getBoolean("success");

            try
            { result              = obj.getJSONObject("result").toString(); }
            catch (JSONException e)
            { result              = obj.getString("result"); }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new CrpResponseException("Exception while receiving a response from the server: "+e.getLocalizedMessage());
        }

        if (!success) throw new CrpResponseException("Response received, but success = false");
        return this;
    }

    public String toString()
    { return "[success = "+success+", result = "+result+"]"; }
}
