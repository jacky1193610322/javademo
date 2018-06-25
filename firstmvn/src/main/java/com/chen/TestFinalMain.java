/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.chen;

import java.lang.reflect.Field;

/**
 * @author jacky
 * @version $Id: TestFinalMain.java, v 0.1 2018-05-20 22:06:15 jacky Exp $
 */
public class TestFinalMain {

    public static void main(String[] args) throws Exception {
        Field nameField = OneCity.class.getDeclaredField("name");
        //nameField.setAccessible(true);  //这个起决定作用
        //nameField.set(null, "Shenzhen");
        //System.out.println(OneCity.getName());  //输出修改后的 Shenzhen

        OneCity oneCity = new OneCity(123124);
        nameField = OneCity.class.getDeclaredField("num");
        nameField.setAccessible(true);  //这个起决定作用
        nameField.set(oneCity, 2223);
        System.out.println(oneCity.getNum());  //输出修改后的 Shenzhen
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}

class OneCity {
    private static String name = "Beijing";

    private final int num;

    public OneCity() {
        this.num = 234;
    }

    public OneCity(int num) {
        this.num = num;
    }

    public static String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

}
