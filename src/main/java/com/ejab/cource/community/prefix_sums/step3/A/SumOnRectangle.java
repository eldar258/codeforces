package com.ejab.cource.community.prefix_sums.step3.A;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;
import java.util.Arrays;

@CreateExecutableFileFrom(ExecutableFiles.INT_INT_TWODINTARRAY_INT_TWODINTARRAY_THEN_LONGARRAY)
public class SumOnRectangle {

    public Long[] calculate(Integer n, Integer m, Integer[][] array1, Integer q, Integer[][] array2) {
        Long[][] prefix2D = getPrefix2D(n, m, array1);

        Long[] result = new Long[q];
        for (int i = 0; i < q; i++) {
            int lx = array2[i][0];
            int ly = array2[i][1];
            int rx = array2[i][2];
            int ry = array2[i][3];

            long lu = prefix2D[lx - 1][ly - 1];
            long ru = prefix2D[lx - 1][ry];
            long ld = prefix2D[rx][ly - 1];
            long rd = prefix2D[rx][ry];

            result[i] = rd - ru - ld + lu;
        }

        return result;
    }

    private Long[][] getPrefix2D(Integer n, Integer m, Integer[][] array) {
        Long[][] prefixSumRows = new Long[n][];
        for (int i = 0; i < n; i++) {
            prefixSumRows[i] = getPrefixSum(m, array[i]);
        }

        Long[][] result = new Long[n + 1][m + 1];
        for (var el : result) {
            Arrays.fill(el, 0L);
        }
        for (int j = 1; j < m + 1; j++) {
            for (int i = 0; i < n; i++) {
                result[i + 1][j] = prefixSumRows[i][j] + result[i][j];
            }
        }

        return result;
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
