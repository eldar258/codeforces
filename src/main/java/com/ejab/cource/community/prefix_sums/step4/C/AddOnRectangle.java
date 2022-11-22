package com.ejab.cource.community.prefix_sums.step4.C;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;

@CreateExecutableFileFrom(ExecutableFiles.INT_INT_TWODINTARRAY_INT_TWODINTARRAY_THEN_TWODLONGARRAY)
public class AddOnRectangle {

    public Long[][] calculate(Integer n, Integer m, Integer[][] array, Integer q, Integer[][] rectangles) {
        Long[][] result = new Long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (long) array[i][j];
            }
        }

        calcPrefixDiff2D(n, m, result);
        for (int i = 0; i < q; i++) {
            addOnRectangle(n, m, result, rectangles[i][0], rectangles[i][1], rectangles[i][2], rectangles[i][3], rectangles[i][4]);
        }
        calcPrefixSum2D(n, m, result);

        return result;
    }

    private void addOnRectangle(Integer n, Integer m, Long[][] result, int lx, int ly, int rx, int ry, int value) {
        lx--;
        ly--;
        result[lx][ly] += value;
        if (rx != n) result[rx][ly] -= value;
        if (ry != m) result[lx][ry] -= value;
        if (rx != n && ry != m) result[rx][ry] += value;
    }

    private void calcPrefixSum2D(Integer n, Integer m, Long[][] result) {
        for (int i = 0; i < n; i++) {
            calcPrefixSum(result[i]);
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                result[i][j] += result[i - 1][j];
            }
        }
    }

    private void calcPrefixSum(Long[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }

    private void calcPrefixDiff2D(Integer n, Integer m, Long[][] result) {
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 1; i--) {
                result[i][j] -= result[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            calcPrefixDiff(result[i]);
        }
    }

    private void calcPrefixDiff(Long[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            array[i] -= array[i - 1];
        }
    }
}
