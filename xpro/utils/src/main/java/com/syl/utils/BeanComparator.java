package com.syl.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 集合元素比较大小排序
 * 可以传入多个比较变量，如果第一个相等，才会比较其它的
 */

public class BeanComparator implements Comparator {


    private String[] fields;

    private List c;

    private int i1 = 1, i2 = -1;

    private String order = "ASC";

    /**
     * @param c      集合
     * @param order  排序方式
     * @param fields 比较字段（可以传入多个）
     */
    public BeanComparator(List c, String order, String... fields) {
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

    public int compare(Map m1, Map m2) {
        int i = 0;
        for (String s:fields) {
            m1.get(s).toString().compareTo(m2.get(s).toString());
            if(i!=0) {
                if ("DESC".equals(this.order.toUpperCase())) {
                    return i1;
                } else {
                    return i2;
                }
            }

        }
        return 0;

    }

    public int compare(Object o1, Object o2) {
        int i = 0;
        Class c1 = (Class) o1.getClass();
        Class c2 = (Class) o2.getClass();
        for (String s : fields) {
            try {

                Field f1 = c1.getDeclaredField(s);
                Class cla1 = f1.getType();
                Field f2 = c2.getDeclaredField(s);
                Class cla2 = f2.getType();
                if (cla1.getName().equals(cla2.getName())) {
                    f1.setAccessible(true);
                    f2.setAccessible(true);
                    String s1 = cla1.getSimpleName();
                    if (s1.equals("Byte")) {
                        if ((Byte) f1.get(o1) > (Byte) f2.get(o2)) {
                            i = i1;
                        } else if ((Byte) f1.get(o1) < (Byte) f2.get(o2)) {
                            i = i2;
                        }

                    } else if (s1.equals("Character")) {
                        if ((Character) f1.get(o1) > (Character) f2.get(o2)) {
                            i = i1;
                        } else if ((Character) f1.get(o1) < (Character) f2.get(o2)) {
                            i = i2;
                        }

                    } else if (s1.equals("Short")) {
                        if ((Short) f1.get(o1) > (Short) f2.get(o2)) {
                            i = i1;
                        } else if ((Short) f1.get(o1) < (Short) f2.get(o2)) {
                            i = i2;
                        }

                    } else if (s1.equals("Integer")) {
                        if ((Integer) f1.get(o1) > (Integer) f2.get(o2)) {
                            i = i1;
                        } else if ((Integer) f1.get(o1) < (Integer) f2.get(o2)) {
                            i = i2;
                        }

                    } else if (s1.equals("Long")) {
                        if ((Long) f1.get(o1) > (Long) f2.get(o2)) {
                            i = i1;
                        } else if ((Long) f1.get(o1) < (Long) f2.get(o2)) {
                            i = i2;
                        }

                    } else if (s1.equals("Float")) {
                        if ((Float) f1.get(o1) > (Float) f2.get(o2)) {
                            i = i1;
                        } else if ((Float) f1.get(o1) < (Float) f2.get(o2)) {
                            i = i2;
                        }

                    } else if (s1.equals("Double")) {
                        if ((Double) f1.get(o1) > (Double) f2.get(o2)) {
                            i = i1;
                        } else if ((Double) f1.get(o1) < (Double) f2.get(o2)) {
                            i = i2;
                        }

                    } else if (s1.equals("Boolean")) {
                        if ((Integer) f1.get(o1) > (Integer) f2.get(o2)) {
                            i = i1;
                        } else if ((Integer) f1.get(o1) < (Integer) f2.get(o2)) {
                            i = i2;
                        }

                    } else {
                        int len1 = ((String) f1.get(o1)).toCharArray().length;
                        int len2 = ((String) f2.get(o2)).toCharArray().length;
                        int lim = Math.min(len1, len2);
                        char v1[] = ((String) f1.get(o1)).toCharArray();
                        char v2[] = ((String) f2.get(o2)).toCharArray();

                        int k = 0;
                        while (k < lim) {
                            char c11 = v1[k];
                            char c12 = v2[k];
                            if (c11 != c12) {
                                i = c11 - c12;
                                if ("DESC".equals(this.order.toUpperCase())) {
                                    return i1;
                                } else {
                                    return i2;
                                }
                            }
                            k++;
                        }
                        return len1 - len2;
                    }
                    if (i == 0) {
                        continue;
                    } else {
                        return i;
                    }
                } else {
                    continue;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}
