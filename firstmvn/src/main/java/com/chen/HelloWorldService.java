/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen;

import com.basetest.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author jacky
 * @version $Id: HelloWorldService.java, v 0.1 2018-05-12 12:52:20 jacky Exp $
 */
class Foo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class HelloWorldService implements FactoryBean<Foo> {
    public Foo getObject() throws Exception {
        return new Foo();
    }

    public Class<?> getObjectType() {
        return Foo.class;
    }

    public boolean isSingleton() {
        return true;
    }

    //public int getOrder() {
    //    return 1;
    //}

    //public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    //    System.out.println("执行BeanPostProcessor的postProcessBeforeInitialization方法,beanName=" + beanName);
    //    return bean;
    //}
    //
    //public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    //    System.out.println("执行BeanPostProcessor的postProcessAfterInitialization方法,beanName=" + beanName);
    //    return bean;
    //}

    private String name;
    private Test   test;

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        System.out.println("I'm  init  method  using  @PostConstrut....");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("I'm  destroy  method  using  @preDestroy");
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String sayHello() {
        return "Hello! " + name;
    }

    public String fun() {
        System.out.println("func");
        return "func";
    }
}

@Component
class HelloWorldServiceAgain implements BeanPostProcessor, Ordered {

    public int getOrder() {
        return 10;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("again before" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("again after " + beanName + bean);
        return bean;
    }
}
