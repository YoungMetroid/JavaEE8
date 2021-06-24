package com.starting.Chapter2_CDI;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.RequestContextController;
import jakarta.inject.Inject;

@ApplicationScoped
public class TaskRCC
{
    private boolean activated;
    @Inject
    private RequestContextController requestContextController;
    public void DoWorkInRequest(String data)
    {
        activated = requestContextController.activate();
        System.out.println(data);
        if(activated)
        {
            requestContextController.deactivate();
            activated =  false;
        }
    }
    public void OtherF()
    {
        if(activated)
        System.out.println("Something");
        else System.out.println("RequestContextController is not activated please activate first");
    }
}
