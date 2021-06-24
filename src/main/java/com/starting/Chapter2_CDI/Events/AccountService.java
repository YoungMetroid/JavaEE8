package com.starting.Chapter2_CDI.Events;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.inject.Inject;

@ApplicationScoped
public class AccountService
{

    @Inject
    private Event<LoginEvent> event;

    public void login(int attemptsMadeCount, String byUserId)
    {
        System.out.println("Login attempt made " + attemptsMadeCount);
        event.fire(new LoginEvent(attemptsMadeCount, byUserId));
    }

    public static void main(String[] args)
    {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize())
        {
            AccountService appInstance = container.select(AccountService.class).get();

            appInstance.login(1,"YoungMetroid");
            appInstance.login(2,"YoungMetroid");
            appInstance.login(3,"YoungMetroid");

        }
    }
}
