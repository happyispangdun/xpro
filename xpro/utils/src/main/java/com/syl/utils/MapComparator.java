package com.syl.utils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 集合元素比较大小排序
 * 可以传入多个比较变量，如果第一个相等，才会比较其它的
 */

public class MapComparator implements Comparator {


    private String[] fields;

    private List c;

    private int i1 = 1, i2 = -1;

    private String order = "ASC";

    /**
     * @param c      集合
     * @param order  排序方式
     * @param fields 比较字段（可以传入多个）
     */
    public MapComparator(List c, String order, String... fields) {
        if ("DESC".equals(order.toUpperCase())) {
            i1 = -1;
            i2 = 1;
            this.order = order;
        }

        this.c = c;
        this.fields = fields;
    }

    public List compare() {
        Collections.sort(c, this);
        return c;
    }

    public int compare(Object m1, Object m2) {
        int i = 0;
        for (String s : fields) {
            i = ((Map) m1).get(s).toString().compareTo(((Map) m2).get(s).toString());
            if (i != 0) {
                if ( i > 0) {
                    return i1;
                } else {
                    return i2;
                }
            }

        }
        return 0;

    }


}
