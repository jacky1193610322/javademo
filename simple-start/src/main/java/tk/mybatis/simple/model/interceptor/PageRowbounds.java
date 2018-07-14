/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.model.interceptor;

import org.apache.ibatis.session.RowBounds;

/**
 * @author jacky
 * @version $Id: PageRowbounds.java, v 0.1 2018-07-13 10:52:38 jacky Exp $
 */
public class PageRowbounds extends RowBounds {
    private long total;

    public PageRowbounds() {
    }

    public PageRowbounds(int offset, int limit) {
        super(offset, limit);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
