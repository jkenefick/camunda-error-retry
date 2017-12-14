package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class HandleError implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        System.out.println("HANDLEERROR!");
    }
}
