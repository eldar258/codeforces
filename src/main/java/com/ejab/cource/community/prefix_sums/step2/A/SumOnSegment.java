package com.ejab.cource.community.prefix_sums.step2.A;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INTARRAY_INT_TWODINTARRAY_THEN_LONGARRAY)
public class SumOnSegment {

    public Long[] calculate(Integer n, Integer[] array, Integer seqNum, Integer[][] sequence) {
        Long[] prefixSum = getPrefixSum(n, array);

        Long[] result = new Long[seqNum];

        for (int i = 0; i < seqNum; i++) {
            result[i] = getSum(prefixSum, sequence[i]);
        }

        return result;
    }

    private Long getSum(Long[] prefixSum, Integer[] integers) {
        int il = integers[0];
        int ir = integers[1];

        return prefixSum[ir] - prefixSum[il - 1];
    }

    private Long[] getPrefixSum(Integer n, Integer[] array) {
        Long[] result = new Long[n + 1];
        result[0] = 0L;

        for (int i = 0; i < n; i++) {
            result[i + 1] = array[i] + result[i];
        }

        return result;
    }
}
