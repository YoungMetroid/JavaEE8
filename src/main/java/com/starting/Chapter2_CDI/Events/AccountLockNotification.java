package com.starting.Chapter2_CDI.Events;


import jakarta.annotation.Priority;
import jakarta.enterprise.event.Observes;

public class AccountLockNotification
{
    public void sendSmsOnAccountLock(@Observes @Priority(2) LoginEvent event)
    {
        if(event.isLockAccount() == false) return;
        sendAccountLockSms
                (event.getUserId());
    }

    private void sendAccountLockSms(String userId)
    {
        System.out.println("SMS to user " + userId);
    }

}
