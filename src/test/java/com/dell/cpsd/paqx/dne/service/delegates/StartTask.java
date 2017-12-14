package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class StartTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        Object failureVar=delegateExecution.getVariable("failure");
        System.out.println("**Start task... failure is: " + failureVar);

        if (failureVar==null)
        {
            System.out.println("**Start task...setting failure to true");
            delegateExecution.setVariable("failure", Boolean.TRUE);
        }
    }
}