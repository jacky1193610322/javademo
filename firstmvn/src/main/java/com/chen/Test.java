/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen;

/**
 * @author jacky
 * @version $Id: Test.java, v 0.1 2018-05-12 13:29:54 jacky Exp $
 */

public class Test {
    private String msg;

    private HelloWorldService helloWorldService;

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
