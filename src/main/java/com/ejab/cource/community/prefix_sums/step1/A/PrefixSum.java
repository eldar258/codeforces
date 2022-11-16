package com.ejab.cource.community.prefix_sums.step1.A;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INT_ARRAY_THEN_LONG_ARRAY)
public class PrefixSum {

    public Long[] calculate(Integer n, Integer[] array) {
        Long[] result = new Long[n + 1];
        result[0] = 0L;
        for (int i = 0; i < n; i++) {
            result[i + 1] = result[i] + array[i];
        }
        return result;
    }
}