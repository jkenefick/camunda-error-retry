/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.unittest;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.repository.ProcessDefinitionQuery;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;

/**
 * @author Daniel Meyer
 * @author Martin Schimak
 */
public class SimpleTestCase {

  @Rule
  public ProcessEngineRule rule = new ProcessEngineRule();

//  @Test
//  @Deployment(resources = {"PreProcess.bpmn"})
//  public void shouldExecuteProcessPreProcessTest() throws InterruptedException
//  {
    // Given we create a new process instance

//    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("preProcess");//,"jackBusinessKey");
//    final RepositoryService repositoryService = repositoryService();
//    final ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
//    final ProcessDefinitionQuery filter = query.processDefinitionId(processInstance.getProcessDefinitionId());
//    final ProcessDefinition result = filter.singleResult();
//    final String name = result.getName();
//    System.out.println("workflowName is: " + name);
//    // Then it should be active
//    assertThat(processInstance).isActive();
//    // And it should be the only instance
//    assertThat(processInstanceQuery().count()).isEqualTo(1);
//    // And there should exist just a single task within that process instance
//    //final List<Task> tasks = taskService().createTaskQuery().list();
//    Task task = taskService().createTaskQuery().processDefinitionId(processInstance.getProcessDefinitionId()).singleResult();
//    //assertThat(task(processInstance)).isNotNull();
//
//    // When we complete that task
//    //final Task task = task(processInstance);
//    complete(task);
//    // Then the process instance should be ended
//    Thread.currentThread().join();
//    //assertThat(processInstance).isEnded();
//  }
//
//  @Test
//  @Deployment(resources = {"testProcess.bpmn"})
//  public void shouldExecuteProcessTestProcessTest() {
//    // Given we create a new process instance
//    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("testProcess");
//    // Then it should be active
//    assertThat(processInstance).isActive();
//    // And it should be the only instance
//    assertThat(processInstanceQuery().count()).isEqualTo(1);
//    // And there should exist just a single task within that process instance
//    Task task=taskService().createTaskQuery().singleResult();
//    //assertThat(task(processInstance)).isNotNull();
//
//    // When we complete that task
//    //final Task task = task(processInstance);
//    complete(task);
//    // Then the process instance should be ended
//    assertThat(processInstance).isEnded();
//  }
//
//  @Test
//  @Deployment(resources = {"bpmnParseListenerOnUserTask.bpmn"})
//  public void shouldExecuteProcessTest() {
//    // Given we create a new process instance
//    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("bpmnParseListenerOnUserTask");
//    // Then it should be active
//    assertThat(processInstance).isActive();
//    // And it should be the only instance
//    assertThat(processInstanceQuery().count()).isEqualTo(1);
//    // And there should exist just a single task within that process instance
//    Task task=taskService().createTaskQuery().singleResult();
//    //assertThat(task(processInstance)).isNotNull();
//
//    // When we complete that task
//    //final Task task = task(processInstance);
//    complete(task);
//
//    task=taskService().createTaskQuery().singleResult();
//    complete(task);
//    // Then the process instance should be ended
//    assertThat(processInstance).isEnded();
//  }

  @Test
  @Deployment(resources = {"jacktest.bpmn"})
  public void shouldExecuteProcessJackTest() throws InterruptedException
  {
    // Given we create a new process instance
    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("jack_process","jackBusinessKey");
    // Then it should be active
//    assertThat(processInstance).isActive();
//    // And it should be the only instance
//    assertThat(processInstanceQuery().count()).isEqualTo(1);
//    // And there should exist just a single task within that process instance
//    Task task=taskService().createTaskQuery().singleResult();
//    //assertThat(task(processInstance)).isNotNull();
//
//    // When we complete that task
    //final Task task = task(processInstance);
    //complete(task);
    // Then the process instance should be ended
    //assertThat(processInstance).isEnded();

    Thread.currentThread().join();
  }

}
