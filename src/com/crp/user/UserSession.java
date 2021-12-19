package com.crp.user;

public class UserSession
{
    public  User    user;
    public  Session session;

    public UserSession() {}

    public String toString()
    { return "[user = "+user+", session = "+session+"]"; }
}
