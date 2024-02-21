package com.macys.pos.coreJava;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetMaxofOcurances_Number {


    @Test
    public void test() {
        int number = 1230000004; int r;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (number > 0) {

            r = number % 10;
            if (map.containsKey(r)) {
                map.put(r, map.get(r) + 1);
            } else {
                map.put(r, 1);
            }
            number = number / 10;
        }
        System.out.print("map" + map);
    }
}
