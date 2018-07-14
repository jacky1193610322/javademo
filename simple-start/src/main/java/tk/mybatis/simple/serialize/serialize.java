/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author jacky
 * @version $Id: serialize.java, v 0.1 2018-07-13 15:47:06 jacky Exp $
 */
public class serialize {
    public static void main(String[] args) throws IOException {
        String msg = "abcd";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(System.out);
        objectOutputStream.writeObject(msg);
    }
}
