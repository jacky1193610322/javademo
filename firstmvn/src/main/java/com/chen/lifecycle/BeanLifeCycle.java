/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Locale;

public class BeanLifeCycle {

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println(System.getenv("chen"));
        System.out.println(System.getProperty("jiang"));

        System.out.println("现在开始初始化容器");

        ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
        Environment env = factory.getEnvironment();
        env.getProperty("chen");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person", Person.class);
        System.out.println(person);
        factory.getMessage("test", null, Locale.CHINA);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}