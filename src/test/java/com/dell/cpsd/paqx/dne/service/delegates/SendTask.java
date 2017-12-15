package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;

import java.util.Map;

public class SendTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        RuntimeService runtimeService = delegateExecution.getProcessEngineServices().getRuntimeService();
        Map<String,Object> vars = (Map<String,Object>)(delegateExecution.getVariable("jackCollectionElement"));
        System.out.println("**SendTask vars are: " + vars);
        System.out.println("**SendTask.. sleeping for 5 seconds");
        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println("**SendTask SLEPT!");
            vars.put("failure", Boolean.FALSE);
            String message=  (String)(vars.get("message"));
            final MessageCorrelationBuilder messageCorrelation = runtimeService.createMessageCorrelation(message);
            final MessageCorrelationBuilder businessKeyFilter = messageCorrelation.processInstanceBusinessKey("jackBusinessKey");

            businessKeyFilter.setVariable("jackCollectionElement", vars).correlateWithResult();
            System.out.println("**SendTask finished thread");
        }).start();
        System.out.println("**SendTask finished execute (thread running still)");
    }
}