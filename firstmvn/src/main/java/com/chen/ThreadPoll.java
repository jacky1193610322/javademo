/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jacky
 * @version $Id: ThreadPoll.java, v 0.1 2018-05-23 10:23:19 jacky Exp $
 */
public class ThreadPoll {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}
