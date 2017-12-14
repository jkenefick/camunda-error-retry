package com.dell.cpsd.paqx.dne.service.delegates2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AfterReceive implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        System.out.println("**AfterReceive");
        //delegateExecution.getProcessEngineServices().getRuntimeService().signalEventReceived("receiveSignal")
    }
}
