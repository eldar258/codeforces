package com.ejab.cource.community.prefix_sums.step4.J;

import collector.CreateExecutableFileFrom;
import collector.CreateExecutableFileFrom.ExecutableFiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

@CreateExecutableFileFrom(ExecutableFiles.BUFFEREDREADER_THEN_L)
public class DesignDecision {

    public long calculate(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (m >= k) return 1_000_000 - k + 1;

        int[] array = new int[1_000_000 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            array[index] = 1;
        }

        calcPrefixSum(array);

        long result = 0;
        for (int i = k; i < array.length; i++) {
            if (array[i] - array[i - k] + m >= k) result++;
        }

        return result;
    }

    private void calcPrefixSum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }
}
