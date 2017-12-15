package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ConcurrentTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        System.out.println("**ConcurrentTask");
        System.out.println("**ConcurrentTask Collection: " + delegateExecution.getVariable("jackCollection"));
        System.out.println("**ConcurrentTask Element: " + delegateExecution.getVariable("jackCollectionElement"));

        Thread.sleep(2000);
    }
}
