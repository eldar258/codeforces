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
        long[] pekorsClones = new long[n];

        for (int i = 0; i < n; i++) {
            int si = trampolines[i];
            long howManyPekorsNeedTake = Math.max(si - 1 - pekorsClones[i], 0);
            pekorsClones[i] += howManyPekorsNeedTake;
            result += howManyPekorsNeedTake;

            if (pekorsClones[i] > 0) { // Pekors clones will jump to other positions to right
                int maxIndexPositionWherePekorCanJump = Math.min(n - 1, si + i);
                for (int j = i + 2; j <= maxIndexPositionWherePekorCanJump; j++) {
                    pekorsClones[j] += 1; // new place of this Pekors clones
                }

                if (i + 1 < n) {
                    long howManyPekorsClonesAreLeftAfterJumping = pekorsClones[i] - (si - 1);
                    pekorsClones[i + 1] += howManyPekorsClonesAreLeftAfterJumping; // Jump to next position, because S == 1
                }
            }

        }
        return result;
    }
}
