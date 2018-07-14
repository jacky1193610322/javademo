/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.ognl;

/**
 * @author jacky
 * @version $Id: Dog.java, v 0.1 2018-07-05 17:00:00 jacky Exp $
 */
public class Dog {
    private String name;

    private String[] friends;

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
