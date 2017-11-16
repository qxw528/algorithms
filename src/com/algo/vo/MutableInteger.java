package com.algo.vo;

/**
 * Created by qiusir on 11/16/17.
 */
public class MutableInteger {
    private int inValue;

    public MutableInteger(int inValue) {
        this.inValue = inValue;
    }

    public int getInValue() {
        return inValue;
    }

    public void setInValue(int inValue) {
        this.inValue = inValue;
    }

    @Override
    public String toString() {
        return "MutableInteger{" +
                "inValue=" + inValue +
                '}';
    }
}
