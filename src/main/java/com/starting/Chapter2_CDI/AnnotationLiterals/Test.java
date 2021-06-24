package com.starting.Chapter2_CDI.AnnotationLiterals;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.inject.Inject;

interface  OrderProcessor{
    public void test();
}

@OrderPlaced
class OrderPlacedProcessor implements OrderProcessor
{
    @Override
    public void test() {
        System.out.println("OrderPlaced");
    }
}

@OrderCancelled
class OrderCancelledProcessor implements OrderProcessor
{
    @Override public void test()
    {
        System.out.println("OrderCancelled");
    }
}


@ApplicationScoped
public class Test {

    @Inject
    @OrderPlaced
    private  OrderProcessor processorA;


    @Inject
    @OrderCancelled
    private OrderProcessor processorB;

    public static void main(String[] args)
    {
        try(SeContainer container = SeContainerInitializer.newInstance().initialize())
        {
            Test appInstance = container.select(Test.class).get();
            appInstance.doWork();
        }
    }

    public void doWork()
    {
        processorA.test();
        processorB.test();
    }
}
