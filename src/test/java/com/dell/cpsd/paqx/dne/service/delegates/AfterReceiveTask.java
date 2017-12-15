package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Map;

public class AfterReceiveTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        final Map<String, Object> vars = (Map<String, Object>) delegateExecution.getVariable("jackCollectionElement");
        System.out.println("**AfterReceiveTask.. vars are: " + vars);
        Thread.sleep(2000);
    }
}