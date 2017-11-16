package com.algo.test;

import java.lang.reflect.Field;

/**
 * Created by qiusir on 11/15/17.
 */
public class Test {

    public static void main(String[] args) {
        int a = 8;
        a <<= 2;
        int b = 8;
        b >>= 2;
        System.out.println(a + ":" + b);
/*        Integer a = 1;
        Integer b = 2;
        System.out.println("before swap:a=" + a + ",b=" + b);
        swap(a,b);
        System.out.println("after  swap:a=" + a + ",b=" + b);*/
    }

    private static void swap(Integer a, Integer b) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int tmp = a.intValue();
            field.set(a,b);
            field.set(b,new Integer(tmp));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
