/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.registerbean.main;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        // 生成代理类的代码
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
        //        "/Users/jacky/java_demo/firstmvn/target/classes/com/chen/registerbean/");
        //System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ApplicationContext factory = new ClassPathXmlApplicationContext("registerbean.xml");

        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) factory;

        // 获取bean工厂并转换为DefaultListableBeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext
                .getBeanFactory();

        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Test.class);

        // 设置属性userAcctDAO,此属性引用已经定义的bean:userAcctDAO
        beanDefinitionBuilder.addPropertyValue("name", "chenyang");
        beanDefinitionBuilder.addPropertyValue("age", "897932384");

        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition("myNewBean", beanDefinitionBuilder.getRawBeanDefinition());

        Test test = factory.getBean("myNewBean", Test.class);
        System.out.println(test.getName());

        //TestAspect testAspect = factory.getBean("testAspect", TestAspect.class);
        //testAspect.print();
        //System.out.println(testAspect.getName());
    }
}