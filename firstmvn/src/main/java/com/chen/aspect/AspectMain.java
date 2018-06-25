/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectMain {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");

        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}