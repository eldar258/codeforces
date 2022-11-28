package com.ejab.cource.community.prefix_sums.step4.G;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INTARRAY_THEN_INTARRAY)
public class SegmentWithMaximumAmount {

    public int[] calculate(int n, int[] array) {
        int result = array[0];
        int lIndex = 0;
        int rIndex = 0;
        int sum = 0;
        int minusPos = -1;

        for (int i = 0; i < n; i++) {
            sum += array[i];
            if (sum > result) {
                result = sum;
                lIndex = minusPos + 1;
                rIndex = i;
            }
            if (sum < 0) {
                sum = 0;
                minusPos = i;
            }
        }

        return new int[]{lIndex + 1, rIndex + 1, result};
    }
}
