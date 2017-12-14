package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;

public class SendTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        RuntimeService runtimeService = delegateExecution.getProcessEngineServices().getRuntimeService();
        System.out.println("**SendTask.. sleeping for 5 seconds");
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                try
                {
                    //System.out.println("ABOUT TO SLEEP");
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println("**SendTask SLEPT!");

            final MessageCorrelationBuilder messageCorrelation = runtimeService.createMessageCorrelation("JackMessage");
            final MessageCorrelationBuilder businessKeyFilter = messageCorrelation.processInstanceBusinessKey("jackBusinessKey");
            businessKeyFilter.setVariable("failure", Boolean.FALSE).correlate();
            System.out.println("**SendTask finished thread");
        }).start();
        System.out.println("**SendTask finished execute (thread running still)");
    }
}
