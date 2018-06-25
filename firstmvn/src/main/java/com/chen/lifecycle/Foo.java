/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.lifecycle;

/**
 * @author jacky
 * @version $Id: Foo.java, v 0.1 2018-06-14 15:33:55 jacky Exp $
 */
public class Foo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("foo setName" + name);
        this.name = name;
    }

    public Foo() {
        System.out.println("foo 构造方法");
    }
}
