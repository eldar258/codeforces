package com.ejab.cource.community.prefix_sums.step2.B;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INTARRAY_INT_INTARRAY_THEN_LONGARRAY)
public class XOROnSeg {

    public Long[] calculate(Integer n, Integer[] array, Integer countSeg, Integer[][] segments) {
        Integer[] prefixXor = getPrefixXOR(n, array);

        Long[] result = new Long[countSeg];
        for (int i = 0; i < countSeg; i++) {
            Integer[] currentSegment = segments[i];
            result[i] = (long) (prefixXor[currentSegment[1]] ^ prefixXor[currentSegment[0] - 1]);
        }

        return result;
    }

    private Integer[] getPrefixXOR(Integer n, Integer[] array) {
        Integer[] result = new Integer[n + 1];
        result[0] = 0;

        for (int i = 0; i < n; i++) {
            result[i + 1] = array[i] ^ result[i];
        }

        return result;
    }
}
