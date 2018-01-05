package com.umland.codility.schneiderelectrictest;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public int solution(int[] A) {
        List<Integer> integers = Arrays.stream(A).filter(a -> a > 0).boxed().distinct().collect(Collectors.toList());

        if (integers.isEmpty()) {
            return 1;
        }

        integers.sort(Comparator.naturalOrder());
        Integer min = integers.stream().min(Comparator.naturalOrder()).orElse(-1);
        Integer max = integers.stream().max(Comparator.naturalOrder()).orElse(-1);
        if (min == -1 || max == -1) {
            return -1;
        }

        if (min > 1) {
            return 1;
        }

        int expectedValue = min;
        for (Integer integer : integers) {
            if (integer != expectedValue) {
                return expectedValue;
            }
            ++expectedValue;
        }

        return max + 1;
    }
}
