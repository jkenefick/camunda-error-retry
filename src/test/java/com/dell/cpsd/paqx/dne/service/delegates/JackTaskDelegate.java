package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class JackTaskDelegate implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        Object failureVar=delegateExecution.getVariable("failure");
        System.out.println("Haha executing... failure is: " + failureVar);


        if (failureVar==null)
        {
            delegateExecution.setVariable("failure", Boolean.TRUE);
        }
        //delegateExecution.setVariable("failure",delegateExecution.getVariable("failure")==null?Boolean.TRUE: Boolean.FALSE);
        //delegateExecution.setVariable("failure",delegateExecution.getVariable("failure")==null?true:false);
    }
}
