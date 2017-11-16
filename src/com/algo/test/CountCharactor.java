package com.algo.test;

import com.algo.vo.MutableInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiusir on 11/16/17.
 */
public class CountCharactor {

    public static void main(String[] args) {
        String strA = "www. tian tian bian ma .com 天 天 编 码";
        String[] strArr = strA.split(" ");

        Map<String,MutableInteger> efficientCounter = new HashMap<String,MutableInteger>();

        for (String str:strArr) {
            MutableInteger initValue = new MutableInteger(1);
            MutableInteger oldValue = efficientCounter.put(str,initValue);
            if (oldValue != null) {
                initValue.setInValue(oldValue.getInValue() + 1);
            }
        }

        for (Map.Entry<String,MutableInteger> entry : efficientCounter.entrySet()) {
            MutableInteger mutableInteger = entry.getValue();
            System.out.println(entry.getKey() + ":" + mutableInteger.getInValue());
        }
    }
}
