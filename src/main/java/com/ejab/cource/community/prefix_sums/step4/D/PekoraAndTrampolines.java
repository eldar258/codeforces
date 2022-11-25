package com.ejab.cource.community.prefix_sums.step4.D;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INTARRAY_TWODINTARRAY_THEN_LARRAY)
public class PekoraAndTrampolines {

    public long[] calculate(int t, int[] arrayLengths, int[][] trampolines) {
        long[] result = new long[t];

        for (int i = 0; i < t; i++) {
            result[i] = calculate(arrayLengths[i], trampolines[i]);
        }

        return result;
    }


    public long calculate(int n, int[] trampolines) {
        long result = 0;
        long[] prefixDiffPekorsClones = new long[n + 3];

        for (int i = 0, j = 1; i < n; i++, j++) {
            prefixDiffPekorsClones[j] += prefixDiffPekorsClones[j - 1];

            long tmp = trampolines[i] - 1 - prefixDiffPekorsClones[j];
            if (tmp > 0) {
                result += tmp;
            } else {
                tmp = -tmp;
                prefixDiffPekorsClones[j + 1] += tmp;
                prefixDiffPekorsClones[j + 2] -= tmp;
            }
            prefixDiffPekorsClones[j + 2] += 1;
            int rightIndex = j + trampolines[i] + 1;
            if (rightIndex < prefixDiffPekorsClones.length) prefixDiffPekorsClones[rightIndex] -= 1;
        }

        return result;
    }
}
