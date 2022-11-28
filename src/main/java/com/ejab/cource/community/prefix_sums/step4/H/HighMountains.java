package com.ejab.cource.community.prefix_sums.step4.H;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INTARRAY_INT_TWODINTARRAY_THEN_INTARRAY)
public class HighMountains {

    public int[] calculate(int n, int[] mountains, int q, int[][] changes) {
        calcPrefixDiff(mountains);

        for (int i = 0; i < q; i++) {
            mountains[n - changes[i][0]] += changes[i][1];
        }

        calcPrefixSum(mountains);

        return mountains;
    }

    private void calcPrefixDiff(int[] mountains) {
        for (int i = mountains.length - 1; i > 0; i--) {
            mountains[i] -= mountains[i - 1];
        }
    }

    private void calcPrefixSum(int[] mountains) {
        for (int i = 1; i < mountains.length; i++) {
            mountains[i] += mountains[i - 1];
        }
    }
}
