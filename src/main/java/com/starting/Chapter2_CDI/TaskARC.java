package com.starting.Chapter2_CDI;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;

@ApplicationScoped
public class TaskARC
{
    @ActivateRequestContext
    public void DoWorkInRequest(String data)
    {
        System.out.println(data);
    }
}
