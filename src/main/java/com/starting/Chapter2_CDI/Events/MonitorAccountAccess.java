package com.starting.Chapter2_CDI.Events;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class MonitorAccountAccess
{
    public static final Integer MAX_ATTEMPTS = 3;


    public void lockForFailedAttempts(@Observes @Priority(1) LoginEvent event)
    {
        if(event.getAttemptsMade() >= MAX_ATTEMPTS)
        {
            event.setLockAccount(true);
            System.out.println("Account is locked");
        }

    }
}
