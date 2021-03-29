package com.starting.Chapter2_CDI;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class BootCDI
{
    public void doSomething()
    {
        System.out.println("Do Something called");
    }

    public static void main(String... args)
    {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize())
    {
        BootCDI appInstance = container.select(BootCDI.class).get();
        appInstance.doSomething();

    }
    }
}
