/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.autowire;

import org.springframework.beans.factory.annotation.Lookup;

/**
 * @author jacky
 * @version $Id: School.java, v 0.1 2018-06-15 11:59:40 jacky Exp $
 */
public class School {
    //@Qualifier("student")
    //Student student;

    private String name;

    //public School(String name) {
    //    this.name = name;
    //}

    public School() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return null;

    }

    @Lookup
    public Student testLookUp(String name) {
        System.out.println("lookup");
        return null;
    }
}
