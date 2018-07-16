/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.ognl;

import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlException;
import org.apache.ibatis.scripting.xmltags.OgnlClassResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacky
 * @version $Id: MybatisOgnl.java, v 0.1 2018-07-10 23:16:02 jacky Exp $
 */
public class MybatisOgnl {
    public static void main(String[] args) throws OgnlException {
        HashMap<String, Object> hashMapHashMap = new HashMap<>();
        HashMap<String, List<Integer>> innerHashMap = new HashMap<>();
        innerHashMap.put("ids", Arrays.asList(1, 2, 3));
        hashMapHashMap.put("_parameter", innerHashMap);
        hashMapHashMap.put("_databaseId", null);

        //System.out.println(OgnlCache.getValue("ids", hashMapHashMap));
        Map<Object, OgnlClassResolver> context = Ognl.createDefaultContext(hashMapHashMap, new OgnlClassResolver());

        Object chenobject = Ognl.parseExpression("_parameter.ids");
        Object cheno2 = Ognl.getValue(chenobject, context, hashMapHashMap);

        System.out.println(cheno2);
        System.out.println(cheno2.getClass());

        System.out.println("**********************");
    }
}
