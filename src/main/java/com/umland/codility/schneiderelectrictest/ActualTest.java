package com.umland.codility.schneiderelectrictest;

import java.util.LinkedHashMap;
import java.util.Map;

public class ActualTest {
    public int solution(int[] A) {
        Map<Integer, Integer> cnts = new LinkedHashMap<>();

        for (int key : A) {
            if (cnts.containsKey(key)) {
                cnts.put(key, 2);
            } else {
                cnts.put(key, 1);
            }
        }

        return cnts.entrySet().stream().filter(entry -> entry.getValue().equals(1)).map(Map.Entry::getKey).findFirst().orElse(-1);
    }
}
