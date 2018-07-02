/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.autowire;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author jacky
 * @version $Id: Student.java, v 0.1 2018-06-15 11:58:32 jacky Exp $
 */
@Component
@Configuration
//@Scope(value = "prototype")
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }
}
