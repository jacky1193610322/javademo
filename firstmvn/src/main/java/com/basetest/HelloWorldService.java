/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.basetest;

public class HelloWorldService {

    private String name;
    private Test   test;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //@PostConstruct
    //public void init() {
    //    System.out.println("I'm  init  method  using  @PostConstrut....");
    //}
    //
    //@PreDestroy
    //public void destroy() {
    //    System.out.println("I'm  destroy  method  using  @preDestroy");
    //}

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

}
