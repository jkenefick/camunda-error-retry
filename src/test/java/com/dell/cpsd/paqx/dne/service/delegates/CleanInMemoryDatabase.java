/**
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved. Dell EMC Confidential/Proprietary Information
 * </p>
 */

package com.dell.cpsd.paqx.dne.service.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * It is responsible for cleaning in memory database.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved. Dell EMC Confidential/Proprietary Information
 * </p>
 *
 * @version 1.0
 * @since 1.0
 */
//@Component
//@Scope("prototype")
@Qualifier("cleanInMemoryDatabase")
public class CleanInMemoryDatabase implements JavaDelegate
{
    public void execute(final DelegateExecution delegateExecution)
    {
        System.out.println("Hello!");
    }
}
