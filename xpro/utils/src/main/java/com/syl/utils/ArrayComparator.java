package com.syl.utils;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ArrayComparator implements Comparator {
    private int[] fields;

    private List c;

    private int i1 = 1, i2 = -1;

    private String order = "ASC";

    /**
     * @param c      集合
     * @param order  排序方式
     * @param fields 比较字段（可以传入多个）
     */
    public ArrayComparator(List c, String order, int... fields) {
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
        for (int s : fields) {
            i = Array.get(m1,s).toString().compareTo(Array.get(m2,s).toString());
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
