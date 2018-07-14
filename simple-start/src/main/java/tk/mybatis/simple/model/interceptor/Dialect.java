/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.model.interceptor;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Properties;

/**
 * @author jacky
 * @version $Id: Dialect.java, v 0.1 2018-07-13 10:46:50 jacky Exp $
 */
public interface Dialect {
    boolean skip(String msId, Object parameterObject, RowBounds rowBounds);

    boolean beforeCount(String msId, Object parameterObject, RowBounds rowBounds);

    String getCountSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey countKey);

    void afterCount(long count, Object parameterObject, RowBounds rowBounds);

    boolean beforePage(String msId, Object parameterObject, RowBounds rowBounds);

    String getPageSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey pageKey);

    Object afterPage(List pageList, Object parameterObject, RowBounds rowBounds);

    void setProperties(Properties properties);

}
