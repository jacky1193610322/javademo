/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.simple.model.interceptor.PageRowbounds;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jacky
 * @version $Id: Main.java, v 0.1 2018-07-05 23:29:49 jacky Exp $
 */
public class Main {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        init();
        testSelectAll();
    }

    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    public static void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("list", Arrays.asList(1, 11, 12));
            hashMap.put("id", 1);
            PageRowbounds pageRowBounds = new PageRowbounds(0, 1);
            List<Country> countryList = sqlSession.selectList("selectAll", hashMap, pageRowBounds);
            printCountryList(countryList);
        } finally {
            sqlSession.close();
        }
    }

    private static void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n", country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }

}
