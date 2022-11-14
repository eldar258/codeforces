package com.ejab.cource.community.prefix_sums.step1.A;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        long[] result = new PrefixSum().calculate(array);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (long l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    private long[] calculate(int[] array) {
        long[] result = new long[array.length + 1];
        result[0] = 0L;
        for (int i = 0; i < array.length; i++) {
            result[i + 1] = result[i] + array[i];
        }
        return result;
    }
}