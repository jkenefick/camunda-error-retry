package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class JackTaskDelegate2 implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        //throw new BpmnError("crap", "crapper");
        System.out.println("Haha executing TWOOOOOOOOO!!!!");
    }
}
