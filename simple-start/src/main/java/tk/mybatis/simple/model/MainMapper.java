/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacky
 * @version $Id: Main.java, v 0.1 2018-07-05 23:29:49 jacky Exp $
 */
public class MainMapper {
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
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Country countryList = countryMapper.selectAll(1);
            printCountryList(Arrays.asList(countryList));
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
