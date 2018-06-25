/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("auto.xml");
        //得到Preson，并使用
        School school = factory.getBean("testAutowire", School.class);
        System.out.println(school.getStudent());
    }
}