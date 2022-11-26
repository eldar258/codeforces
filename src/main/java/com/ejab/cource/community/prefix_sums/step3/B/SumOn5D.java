package com.ejab.cource.community.prefix_sums.step3.B;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

@CreateExecutableFileFrom(ExecutableFiles.BUFFEREDREADER_THEN_LONGARRAY)
public class SumOn5D {

    public Long[] calculate(String string) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(string));
        return calculate(bufferedReader);
    }

    public Long[] calculate(BufferedReader bufferedReader) throws IOException {
        int[] n5 = readLineArray(bufferedReader);
        int[][][][][] array5D = read5DArray(n5, bufferedReader);
        int q = Integer.parseInt(bufferedReader.readLine());
        int[][] array2D = read2DArray(q, bufferedReader);

        return calculate(n5[0], n5[1], n5[2], n5[3], n5[4], array5D, q, array2D);
    }

    private int[][][][][] read5DArray(int[] n5, BufferedReader bufferedReader) throws IOException {
        int[][][][][] result = new int[n5[0]][][][][];
        for (int i = 0; i < n5[0]; i++) {
            result[i] = read4DArray(n5, bufferedReader);
        }

        return result;
    }

    private int[][][][] read4DArray(int[] n5, BufferedReader bufferedReader) throws IOException {
        int[][][][] result = new int[n5[1]][][][];
        for (int i = 0; i < n5[1]; i++) {
            result[i] = read3DArray(n5, bufferedReader);
        }

        return result;
    }

    private int[][][] read3DArray(int[] n5, BufferedReader bufferedReader) throws IOException {
        int[][][] result = new int[n5[2]][][];
        for (int i = 0; i < n5[2]; i++) {
            result[i] = read2DArray(n5[3], bufferedReader);
        }

        return result;
    }

    private int[][] read2DArray(int n, BufferedReader bufferedReader) throws IOException {
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = readLineArray(bufferedReader);
        }

        return result;
    }

    private int[] readLineArray(BufferedReader bufferedReader) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = stringTokenizer.countTokens();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return result;
    }

    private Long[] calculate(int n1, int n2, int n3, int n4, int n5, int[][][][][] array5d, int q, int[][] cornerCoordinates) {
        long[][][][][] prefixSum = getPrefixSum(n1, n2, n3, n4, n5, array5d);

        Long[] result = new Long[q];
        for (int i = 0; i < q; i++) {
            result[i] = getSumByCorners(prefixSum, cornerCoordinates[i]);
        }

        return result;
    }

    private long getSumByCorners(long[][][][][] prefixSum, int[] cornerCoordinate) {
        int l1 = cornerCoordinate[0] - 1;
        int l2 = cornerCoordinate[1] - 1;
        int l3 = cornerCoordinate[2] - 1;
        int l4 = cornerCoordinate[3] - 1;
        int l5 = cornerCoordinate[4] - 1;

        int r1 = cornerCoordinate[5];
        int r2 = cornerCoordinate[6];
        int r3 = cornerCoordinate[7];
        int r4 = cornerCoordinate[8];
        int r5 = cornerCoordinate[9];

        return prefixSum[r1][r2][r3][r4][r5]
                - prefixSum[r1][r2][r3][r4][l5]
                - prefixSum[r1][r2][r3][l4][r5]
                - prefixSum[r1][r2][l3][r4][r5]
                - prefixSum[r1][r2][l3][l4][l5]
                - prefixSum[r1][l2][r3][r4][r5]
                - prefixSum[r1][l2][r3][l4][l5]
                - prefixSum[r1][l2][l3][r4][l5]
                - prefixSum[r1][l2][l3][l4][r5]
                - prefixSum[l1][r2][r3][r4][r5]
                - prefixSum[l1][r2][r3][l4][l5]
                - prefixSum[l1][r2][l3][r4][l5]
                - prefixSum[l1][r2][l3][l4][r5]
                - prefixSum[l1][l2][r3][r4][l5]
                - prefixSum[l1][l2][r3][l4][r5]
                - prefixSum[l1][l2][l3][r4][r5]

                + prefixSum[r1][r2][r3][l4][l5]
                + prefixSum[r1][r2][l3][r4][l5]
                + prefixSum[r1][r2][l3][l4][r5]
                + prefixSum[r1][l2][r3][r4][l5]
                + prefixSum[r1][l2][r3][l4][r5]
                + prefixSum[r1][l2][l3][r4][r5]
                + prefixSum[r1][l2][l3][l4][l5]
                + prefixSum[l1][r2][r3][r4][l5]
                + prefixSum[l1][r2][r3][l4][r5]
                + prefixSum[l1][r2][l3][r4][r5]
                + prefixSum[l1][r2][l3][l4][l5]
                + prefixSum[l1][l2][r3][r4][r5]
                + prefixSum[l1][l2][r3][l4][l5]
                + prefixSum[l1][l2][l3][r4][l5]
                + prefixSum[l1][l2][l3][l4][r5]

                - prefixSum[l1][l2][l3][l4][l5]
                ;
    }

    private long[][][][][] getPrefixSum(int n1, int n2, int n3, int n4, int n5, int[][][][][] array5d) {
        long[][][][][] result = new long[n1 + 1][n2 + 1][n3 + 1][n4 + 1][n5 + 1];
        long[][][][][] prefixSum4d = new long[n1][n2 + 1][n3 + 1][n4 + 1][n5 + 1];

        for (int i = 0; i < n1; i++) {
            prefixSum4d[i] = getPrefixSum4D(n2, n3, n4, n5, array5d[i]);
        }

        for (int j = 1; j <= n5; j++) {
            for (int i = 1; i <= n4; i++) {
                for (int k = 1; k <= n3; k++) {
                    for (int l = 1; l <= n2; l++) {
                        for (int m = 0; m < n1; m++) {
                            result[m + 1][l][k][i][j] = prefixSum4d[m][l][k][i][j] + result[m][l][k][i][j];
                        }
                    }
                }
            }
        }

        return result;
    }

    private long[][][][] getPrefixSum4D(int n1, int n2, int n3, int n4, int[][][][] array4d) {
        long[][][][] result = new long[n1 + 1][n2 + 1][n3 + 1][n4 + 1];
        long[][][][] prefixSum3d = new long[n1][n2 + 1][n3 + 1][n4 + 1];

        for (int i = 0; i < n1; i++) {
            prefixSum3d[i] = getPrefixSum3D(n2, n3, n4, array4d[i]);
        }

        for (int j = 1; j <= n4; j++) {
            for (int i = 1; i <= n3; i++) {
                for (int k = 1; k <= n2; k++) {
                    for (int l = 0; l < n1; l++) {
                        result[l + 1][k][i][j] = prefixSum3d[l][k][i][j] + result[l][k][i][j];
                    }
                }
            }
        }

        return result;
    }

    private long[][][] getPrefixSum3D(int n1, int n2, int n3, int[][][] array3d) {
        long[][][] result = new long[n1 + 1][n2 + 1][n3 + 1];
        long[][][] prefixSum2d = new long[n1][n2 + 1][n3 + 1];

        for (int i = 0; i < n1; i++) {
            prefixSum2d[i] = getPrefixSum2D(n2, n3, array3d[i]);
        }

        for (int j = 1; j <= n3; j++) {
            for (int i = 1; i <= n2; i++) {
                for (int k = 0; k < n1; k++) {
                    result[k + 1][i][j] = prefixSum2d[k][i][j] + result[k][i][j];
                }
            }
        }

        return result;
    }

    private long[][] getPrefixSum2D(int n, int m, int[][] array2d) {
        long[][] result = new long[n + 1][m + 1];
        long[][] prefixSumLines = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            prefixSumLines[i] = getPrefixSum(m, array2d[i]);
        }

        for (int j = 1; j <= m; j++) {
            for (int i = 0; i < n; i++) {
                result[i + 1][j] = prefixSumLines[i][j] + result[i][j];
            }
        }

        return result;
    }

    private long[] getPrefixSum(int m, int[] array) {
        long[] result = new long[m + 1];

        for (int i = 0; i < m; i++) {
            result[i + 1] = array[i] + result[i];
        }

        return result;
    }
}
