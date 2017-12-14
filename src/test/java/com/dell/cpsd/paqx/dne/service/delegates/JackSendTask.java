package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.DelegationState;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;

import java.util.List;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.processEngine;

public class JackSendTask implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution) throws Exception
    {
        RuntimeService runtimeService=delegateExecution.getProcessEngineServices()
                //                .getRuntimeService().createMessageCorrelation("Message_11xo5g3")
                .getRuntimeService();
        System.out.println("**SEND TASK.. sleeping for 5 seconds");
        new Thread(()-> {
            for (int i=0; i<5; i++)
            {
                try
                {
                    System.out.println("ABOUT TO SLEEP");
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                TaskQuery taskQuery = processEngine().getTaskService().createTaskQuery();

                List<Task> tasks = taskQuery.processInstanceId("jackBusinessKey").list();
                System.out.println("tasks are: " + tasks);

                for (Task task : tasks) {
                    if (task.getDelegationState() == DelegationState.PENDING) {
                        // do stuff
                        System.out.println("PENDING: "+ task);
                    }
                }
            }
            System.out.println("SLEPT!");
            //delegateExecution.setVariable("failure",Boolean.FALSE);
            //System.out.println(getAllRunningProcessInstances("jackBusinessKey"));
            //        delegateExecution.getProcessEngineServices()
            //                .getRuntimeService().correlateMessage("Message_0vmo6lg");
            //.getRuntimeService().correlateMessage("Message_11xo5g3");



            final MessageCorrelationBuilder messageCorrelation = runtimeService
                    .createMessageCorrelation("JackMessage");
            final MessageCorrelationBuilder businessKeyFilter = messageCorrelation.processInstanceBusinessKey("jackBusinessKey");
            MessageCorrelationResult result =businessKeyFilter.setVariable("failure", Boolean.FALSE).correlateWithResult();
            System.out.println("Result is: " + result);
        }).start();
        System.out.println("FINISHED IN SEND TASK (APART FROM THREAD)");



//        delegateExecution.getProcessEngineServices()
//                .getRuntimeService().signalEventReceived("receiveSignal");
                //.getRuntimeService().createSignalEvent("receiveSignal").send();//signal((delegateExecution.getId());
//        delegateExecution.getProcessEngineServices()
//                .getRuntimeService()
//                .createMessageCorrelation("Message_0vmo6lg")
//                .processInstanceBusinessKey("jackBusinessKey")
//
//                .correlate();
    }

    public List<ProcessInstance> getAllRunningProcessInstances(String processDefinitionName) {
        // get process engine and services
        ProcessEngine processEngine = BpmPlatform.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // query for latest process definition with given name
        ProcessDefinition myProcessDefinition =
                repositoryService.createProcessDefinitionQuery()
                        .processDefinitionName(processDefinitionName)
                        .latestVersion()
                        .singleResult();

        // list all running/unsuspended instances of the process
        List<ProcessInstance> processInstances =
                runtimeService.createProcessInstanceQuery()
                        .processDefinitionId(myProcessDefinition.getId())
                        .active() // we only want the unsuspended process instances
                        .list();

        return processInstances;
    }
}
