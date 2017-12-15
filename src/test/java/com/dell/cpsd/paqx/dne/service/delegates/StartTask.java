package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Map;

public class StartTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        Map<String,Object> vars = (Map<String,Object>)(delegateExecution.getVariable("jackCollectionElement"));
        Boolean failure = (Boolean)(vars.get("failure"));
        System.out.println("**Start task... failure is: " + failure);

        if (failure==null)
        {
            boolean failureSet=Math.random() > .5 ? Boolean.TRUE:Boolean.FALSE;
            System.out.println("**Start task...setting failure to " + failureSet);
            vars.put("failure", failureSet );
        }
    }
}