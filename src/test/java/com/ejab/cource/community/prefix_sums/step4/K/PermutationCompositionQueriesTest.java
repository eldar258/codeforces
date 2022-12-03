package com.ejab.cource.community.prefix_sums.step4.K;

import static com.ejab.Helper.assertArray;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class PermutationCompositionQueriesTest {

    @Test
    @Timeout(value = 3)
    void calculate() throws IOException {
        PermutationCompositionQueries permutationCompositionQueries = new PermutationCompositionQueries();

        assertArray(
                new long[][]{{
                        10,
                        11,
                        11,
                        14,
                        11}},
                permutationCompositionQueries.calculate(new BufferedReader(new StringReader("""
                        1
                        4 3
                        3 2 1
                        1 3 2
                        1 2 3
                        2 3 1
                        5
                        1 1
                        1 4
                        3 4
                        3 3
                        1 3
                        """)))
        );
    }

    @Test
    @Timeout(value = 3)
    void calculate2() throws IOException {
        PermutationCompositionQueries permutationCompositionQueries = new PermutationCompositionQueries();

        assertArray(
                new long[][]{{
                        21,
                        27,
                        21,
                        27,
                        26,
                        28,
                        21
                }},
                permutationCompositionQueries.calculate(new BufferedReader(new StringReader("""
                        1
                        4 4
                        4 3 1 2
                        2 4 1 3
                        3 1 2 4
                        2 3 4 1
                        7
                        1 1
                        3 3
                        1 4
                        1 3
                        2 3
                        2 4
                        3 4
                        """)))
        );
    }

    @Test
    void calculate3() {
        PermutationCompositionQueries permutationCompositionQueries = new PermutationCompositionQueries();

        int n = 2;
        int m = 100000;
        int[][] array = new int[n][m];
        int[][] requests = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = m - 1; j < m && k >= 0; k--, j++) {
                array[i][j] = k;
            }
        }
        for (int i = 0; i < requests.length; i++) {
            requests[i] = new int[]{0, 1};
        }

        long[] expected = new long[m];
        long sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += (long) i * i;
        }
        Arrays.fill(expected, sum);

        assertTimeout(Duration.ofSeconds(3), () -> assertArray(
                expected,
                permutationCompositionQueries.calculate(array, requests)
        ));
    }

    @Test
    @Timeout(value = 3)
    void calculate4() throws IOException {
        PermutationCompositionQueries permutationCompositionQueries = new PermutationCompositionQueries();

        assertArray(
                new long[][]{{
                        21,
                        27,
                        21,
                        27,
                        26,
                        28,
                        21,
                        21,
                        27,
                        21,
                        27,
                        26,
                        28,
                        21
                }},
                permutationCompositionQueries.calculate(new BufferedReader(new StringReader("""
                        1
                        4 4
                        4 3 1 2
                        2 4 1 3
                        3 1 2 4
                        2 3 4 1
                        14
                        1 1
                        3 3
                        1 4
                        1 3
                        2 3
                        2 4
                        3 4
                        1 1
                        3 3
                        1 4
                        1 3
                        2 3
                        2 4
                        3 4
                        """)))
        );
    }

    @Test
    void calculate5() {
        PermutationCompositionQueries permutationCompositionQueries = new PermutationCompositionQueries();

        int n = 2;
        int m = 100000;
        int[][] array = new int[n][m];
        int[][] requests = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = j;
            }
        }
        for (int i = 0; i < requests.length; i++) {
            requests[i] = new int[]{0, 1};
        }

        long[] expected = new long[m];
        long sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += (long) i * i;
        }
        Arrays.fill(expected, sum);

        assertTimeout(Duration.ofSeconds(3), () -> assertArray(
                expected,
                permutationCompositionQueries.calculate(array, requests)
        ));
    }
}