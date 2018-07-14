/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.ognl;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jacky
 * @version $Id: Main.java, v 0.1 2018-07-05 17:00:20 jacky Exp $
 */
public class Main {
    public static void main(String[] args) throws OgnlException {

        Person person = new Person();
        person.setName("Steven");

        Dog dog2 = new Dog();
        dog2.setName("hello world");

        person.setDog(dog2);

        Dog dog = new Dog();
        dog.setName("hello world your sister");

        OgnlContext context = new OgnlContext();

        HashMap<String, HashMap<String, String>> hashMapHashMap = new HashMap<>();
        HashMap<String, String> innerHashMap = new HashMap<>();
        innerHashMap.put("chen", "yang");
        hashMapHashMap.put("pa", innerHashMap);
        context.put("pa", innerHashMap);
        context.put("jiayou", null);
        context.setRoot(hashMapHashMap);

        Object chenobject = Ognl.parseExpression("chen");

        Object cheno2 = Ognl.getValue(chenobject, context, context.getRoot());

        System.out.println(cheno2);

        System.out.println("**********************");

        // 把对象以键值对形式放进去
        context.put("person", person);
        context.put("dog", dog);

        // 设定这个OGNL的根root是person对象
        context.setRoot(person);

        // 解析一个表达式（取跟对象的属性的时候，无需加#，直接写属性名字，默认从根对象中取属性）
        Object object = Ognl.parseExpression("name");

        System.out.println(object);

        Object object2 = Ognl.getValue(object, context, context.getRoot());

        System.out.println(object2);

        System.out.println("----------------------------");

        // #表示取的不是根对象，表示取context里面存的person对象里面的name属性
        Object object3 = Ognl.parseExpression("#person.name");

        System.out.println(object3);

        Object object4 = Ognl.getValue(object3, context, context.getRoot());

        System.out.println(object4);

        System.out.println("----------------------------");

        // #表示取的不是根对象，表示取context里面存的dog对象里面的name属性
        Object object5 = Ognl.parseExpression("#dog.name");

        System.out.println(object5);

        Object object6 = Ognl.getValue(object5, context, context.getRoot());

        System.out.println(object6);

        System.out.println("----------------------------");

        // 属性后买年可以直接调String的方法
        Object object7 = Ognl.parseExpression("name.toUpperCase().length()");

        System.out.println(object7);

        Object object8 = Ognl.getValue(object7, context, context.getRoot());

        System.out.println(object8);

        System.out.println("----------------------------");

        // 调用ONGL的静态方法时用两个@@符号：@表示类名@表示方法名
        Object object9 = Ognl.parseExpression("@java.lang.Integer@toBinaryString(10)");

        System.out.println(object9);

        Object object10 = Ognl.getValue(object9, context, context.getRoot());

        System.out.println(object10);

        System.out.println("----------------------------");

        // 调用ONGL的静态方法时用两个@@符号：不写类名，默认是java.lang.Math类，@@直接写Math类里面的方法
        Object object11 = Ognl.parseExpression("@@min(4, 10)");

        System.out.println(object11);

        Object object12 = Ognl.getValue(object11, context, context.getRoot());

        System.out.println(object12);

        System.out.println("----------------------------");

        // new一个LinkedList
        Object object13 = Ognl.parseExpression("new java.util.LinkedList()");

        System.out.println(object13);

        Object object14 = Ognl.getValue(object13, context, context.getRoot());

        System.out.println(object14);

        System.out.println("----------------------------");

        // 一个字符串集合（外面用双引号了，里面就用单引号），
        Object object15 = Ognl.getValue("{'aa', 'bb', 'cc', 'dd'}", context, context.getRoot());

        System.out.println(object15);

        System.out.println("----------------------------");

        // 一个字符串集合（OGNL中，集合与数组是等同的），取第三个元素
        Object object16 = Ognl.getValue("{'aa', 'bb', 'cc', 'dd'}[2]", context, context.getRoot());

        System.out.println(object15);

        System.out.println("----------------------------");

        dog.setFriends(new String[] {"aa", "bb", "cc"});
        // dog对象的friends数组
        Object object17 = Ognl.getValue("#dog.friends", context, context.getRoot());

        System.out.println(object17);

        System.out.println("----------------------------");

        dog.setFriends(new String[] {"aa", "bb", "cc"});
        // dog对象的friends数组的第二个元素
        Object object18 = Ognl.getValue("#dog.friends[1]", context, context.getRoot());

        System.out.println(object18);

        List<String> list = new ArrayList<String>(Arrays.asList("hello", "world", "hello world"));

        context.put("list", list);

        System.out.println(Ognl.getValue("#list", context, context.getRoot()));
        System.out.println(Ognl.getValue("#list[1]", context, context.getRoot()));

        System.out.println("----------------------------");

        // OGNL的映射（Map）:#{}表示这是一个映射Map,这里的#与取非根元素的#不同，仅仅表示这是一个映射Map而已
        System.out.println(
                Ognl.getValue("#{'key1': 'value1', 'key2': 'value2', 'key3': 'value3', 'key4': 'value4'}", context, context.getRoot()));
        // OGNL返回映射中某key对应的value
        System.out.println(Ognl.getValue("#{'key1': 'value1', 'key2': 'value2', 'key3': 'value3', 'key4': 'value4'}['key3']", context,
                context.getRoot()));

        System.out.println("----------------------------");

        List<Person> persons = new ArrayList<Person>(Arrays.asList(new Person("doctor"), new Person("worker"), new Person("student")));

        context.put("persons", persons);

        // 过滤:collection.{?开头
        // expression},对一个集合进行过滤，返回过滤后结果(OGNL提供了伪属性，"#persons.{? #this.name.length() > 4}.size"也可以）
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}", context, context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}.size()", context, context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}[0].name", context, context.getRoot()));

        // 过滤（filtering）,获取到过滤后的集合中的第一个元素^, collection.{^ expression}
        System.out.println(Ognl.getValue("#persons.{^ #this.name.length() > 4}", context, context.getRoot()));

        // 过滤（filtering）,获取到过滤后的集合中的第一个元素$, collection.{$ expression}
        System.out.println(Ognl.getValue("#persons.{$ #this.name.length() > 4}", context, context.getRoot()));

        System.out.println("----------------------------");

        // 投影（projection）, collection. {expression}
        System.out.println(Ognl.getValue("#persons.{name}", context, context.getRoot()));

        System.out.println("----------------------------");

        System.out.println(Ognl.getValue("#persons.{#this.name.length() <= 5 ? 'Hello World' : #this.name}", context, context.getRoot()));

    }
}

