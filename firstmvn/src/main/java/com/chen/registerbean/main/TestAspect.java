/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.registerbean.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jacky
 * @version $Id: TestAspect.java, v 0.1 2018-06-29 17:41:57 jacky Exp $
 */
@Component(value = "testAspect")
public class TestAspect {
    @Value(value = "")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("print");
    }
}
