package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PassThroughTask implements JavaDelegate
{
    @Override
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        System.out.println("**PassThroughTask");
    }
}