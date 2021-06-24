package com.starting.Chapter2_CDI;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;


@ApplicationScoped
public class TaskARC
{
    @ActivateRequestContext
    public void DoWorkInRequest(String data)
    {
        System.out.println(data);
    }
}
