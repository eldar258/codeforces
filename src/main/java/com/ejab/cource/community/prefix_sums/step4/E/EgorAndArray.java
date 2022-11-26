package com.ejab.cource.community.prefix_sums.step4.E;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

@CreateExecutableFileFrom(ExecutableFiles.BUFFEREDREADER_THEN_LARRAY)
public class EgorAndArray {

    public long[] calculate(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[][] operations = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int count = st.countTokens();
            operations[i] = new int[count];
            for (int j = 0; j < count; j++) {
                operations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] requests = new int[k][];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int count = st.countTokens();
            requests[i] = new int[count];
            for (int j = 0; j < count; j++) {
                requests[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return calculate(n, m, k, array, operations, requests);
    }

    private long[] calculate(int n, int m, int k, int[] array, int[][] operations, int[][] requests) {
        long[] arrayLong = Arrays.stream(array).mapToLong(Long::valueOf).toArray();

        long[] collectRequests = new long[m];
        for (int i = 0; i < k; i++) {
            culcOperation(m, collectRequests, requests[i][0], requests[i][1], 1);
        }
        culcPrefixSum(collectRequests);

        culcPrefixDiff(arrayLong);

        for (int i = 0; i < collectRequests.length; i++) {
                culcOperation(n, arrayLong, operations[i][0], operations[i][1], operations[i][2] * collectRequests[i]);
        }

        culcPrefixSum(arrayLong);
        return arrayLong;
    }

    private void culcPrefixSum(long[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }

    private void culcOperation(int n, long[] array, int start, int end, long value) {
        array[start - 1] += value;
        if (end < n) array[end] -= value;
    }

    private void culcPrefixDiff(long[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            array[i] -= array[i - 1];
        }
    }
}
