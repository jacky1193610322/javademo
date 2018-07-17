/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.model;

import org.apache.ibatis.annotations.Select;

/**
 * @author jacky
 * @version $Id: CountryMapper.java, v 0.1 2018-07-17 16:29:33 jacky Exp $
 */
public interface CountryMapper {
    @Select("SELECT id, countryname, countrycode  from country WHERE id = #{id}")
    Country selectAll(int id);
}
