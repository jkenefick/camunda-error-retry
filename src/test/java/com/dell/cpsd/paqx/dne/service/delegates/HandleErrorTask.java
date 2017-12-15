package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class HandleErrorTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        System.out.println("**HandleErrorTask!");
        System.out.println("**HandleErrorTask! Element: " + delegateExecution.getVariable("jackCollectionElement"));
        throw new BpmnError("oops","a daisy");
    }
}
