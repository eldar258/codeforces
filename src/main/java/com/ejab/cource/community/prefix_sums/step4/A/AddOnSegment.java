package com.ejab.cource.community.prefix_sums.step4.A;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INTARRAY_INT_TWODINTARRAY_THEN_LONGARRAY)
public class AddOnSegment {

    public Long[] calculate(Integer n, Integer[] array, Integer q, Integer[][] segmentsAndValues) {
        Long[] result = new Long[n];
        for (int i = 0; i < n; i++) {
            result[i] = (long) array[i];
        }

        calcPrefixDiff(result);
        for (int i = 0; i < q; i++) {
            addOnSegment(result, segmentsAndValues[i][0], segmentsAndValues[i][1], segmentsAndValues[i][2]);
        }
        calcPrefixSum(result);

        return result;
    }

    private void calcPrefixSum(Long[] result) {
        for (int i = 1; i < result.length; i++) {
            result[i] +=result[i - 1];
        }
    }

    private void calcPrefixDiff(Long[] result) {
        for (int i = result.length - 1; i >= 1; i--) {
            result[i] -= result[i - 1];
        }
    }

    private void addOnSegment(Long[] result, Integer start, Integer end, Integer value) {
            result[start - 1] += value;
            if (end != result.length) result[end] -= value;
    }
}
