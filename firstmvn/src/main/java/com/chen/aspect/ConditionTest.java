/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen.aspect;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jacky
 * @version $Id: ConditionTest.java, v 0.1 2018-05-18 11:56:45 jacky Exp $
 */
public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private static Condition condition1 = lock.newCondition();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                try {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.lock();
                    System.out.println(Thread.currentThread() + "等待条件完成");
                    condition.await();

                    //System.out.println("condition1 await");
                    //condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread() + "终于等到条件完成了，gogogo");
                    lock.unlock();
                }
            }
        }).start();

        Thread b = new Thread(new Runnable() {
            public void run() {
                try {

                    lock.lock();
                    condition.signal();

                    System.out.println("condition1 signal");
                    //condition1.signal();
                    //System.out.println(Thread.currentThread() + "条件完成了，释放吧");
                } finally {
                    lock.unlock();
                }
            }
        });
        b.start();
    }
}
