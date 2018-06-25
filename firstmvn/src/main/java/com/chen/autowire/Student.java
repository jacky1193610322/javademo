/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.autowire;

import org.springframework.stereotype.Component;

/**
 * @author jacky
 * @version $Id: Student.java, v 0.1 2018-06-15 11:58:32 jacky Exp $
 */
@Component
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
