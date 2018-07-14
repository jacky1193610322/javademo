/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        //ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        for (String arg : args) {
            System.out.println(arg);
        }
        Properties properties = System.getProperties();

        {
            System.out.println(7 + "Hello!");
            int i = 40;
            String as_e1 = String.valueOf(i < 50 ? 233 : 666);
            String as_e2 = String.valueOf(i < 50 ? 233 : 666.0);
            System.out.println(as_e1);
            System.out.println(as_e2);
        }

        ApplicationContext factory = new ClassPathXmlApplicationContext("auto.xml");
        //得到Preson，并使用
        School school = factory.getBean("testAutowire", School.class);
        Student student = factory.getBean(Student.class, "test");
        //System.out.println(student.getName());
        System.out.println("--------------");
        //System.out.println(school.getStudent());
        System.out.println(school.testLookUp("test"));
        System.out.println(school.testLookUp("test").getName());

        /*
            XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("auto.xml"));
            String name = xmlBeanFactory.getBean("testAutowire", School.class, "chenyang").getName();
            System.out.println(name);
        */
    }
}