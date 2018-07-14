/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.ognl;

/**
 * @author jacky
 * @version $Id: Person.java, v 0.1 2018-07-05 17:01:38 jacky Exp $
 */
public class Person {
    private String name;

    private Dog dog;

    public Person() {
        super();
    }

    public Person(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        System.out.println("getName invoked!");

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

