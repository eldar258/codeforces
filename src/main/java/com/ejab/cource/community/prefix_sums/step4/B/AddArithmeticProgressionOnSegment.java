package com.ejab.cource.community.prefix_sums.step4.B;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INTARRAY_INT_TWODINTARRAY_THEN_LONGARRAY)
public class AddArithmeticProgressionOnSegment {

    public Long[] calculate(Integer n, Integer[] array, Integer q, Integer[][] segmentsAndValues) {
        Long[] result = new Long[n];
        for (int i = 0; i < n; i++) {
            result[i] = (long) array[i];
        }

        calcPrefixDiff(n, result);
        calcPrefixDiff(n, result);
        for (int i = 0; i < q; i++) {
            addOnSegments(result, segmentsAndValues[i][0], segmentsAndValues[i][1], segmentsAndValues[i][2]);
        }
        calcPrefixSum(n, result);
        calcPrefixSum(n, result);

        return result;
    }

    private void addOnSegments(Long[] result, Integer start, Integer end, Integer value) {
        start--;
        result[start] += value;
        if (end != result.length) {
            result[end] -= (long) (end - start + 1) * value;
        } else return;
        if (end + 1 != result.length) result[end + 1] += (long) (end - start) * value;
    }

    private void calcPrefixSum(Integer n, Long[] result) {
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }
    }

    private void calcPrefixDiff(Integer n, Long[] result) {
        for (int i = n - 1; i >= 1; i--) {
            result[i] -= result[i - 1];
        }
    }
}
