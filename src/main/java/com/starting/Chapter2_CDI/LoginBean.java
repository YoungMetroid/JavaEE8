package com.starting.Chapter2_CDI;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class LoginBean
{
    public LoginBean()
    {
        System.out.println("new LoginBean created");
    }
}
