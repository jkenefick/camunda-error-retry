package com.dell.cpsd.paqx.dne.service.delegates2;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class BeforeReceive implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        System.out.println("**BEFORE RECEIVE");
        //delegateExecution.getProcessEngineServices().getRuntimeService().signalEventReceived("receiveSignal")
    }
}
