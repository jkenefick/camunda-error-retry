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

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.runtimeService;

/**
 * @author Daniel Meyer
 * @author Martin Schimak
 */
public class SimpleTestCase
{

    @Rule
    public ProcessEngineRule rule = new ProcessEngineRule();

    @Test
    @Deployment(resources = {"jacktest.bpmn"})
    public void shouldExecuteProcessJackTest() throws InterruptedException
    {
        // Given we create a new process instance
        Map<String, Object> variables = new HashMap<>();
        List<Map> vars = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("message", "JackMessage1");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("message", "JackMessage2");
        Map<String, Object> map3 = new HashMap<>();
        map3.put("message", "JackMessage3");
        vars.add(map1);
        vars.add(map2);
        vars.add(map3);
        variables.put("jackCollection", vars);
        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("jack_process", "jackBusinessKey", variables);
        Thread.currentThread().join();
    }
}