/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("beans1.xml");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}