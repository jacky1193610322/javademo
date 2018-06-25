/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jacky
 * @version $Id: School.java, v 0.1 2018-06-15 11:59:40 jacky Exp $
 */
public class School {
    @Autowired
    Student student;

    public Student getStudent() {
        return student;
    }
}
