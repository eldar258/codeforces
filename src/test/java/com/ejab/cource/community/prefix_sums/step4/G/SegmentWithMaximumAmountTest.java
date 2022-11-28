package com.ejab.cource.community.prefix_sums.step4.G;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntArray;

import org.junit.jupiter.api.Test;

class SegmentWithMaximumAmountTest {

    @Test
    void calculate() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("1 1 1"),
                segmentWithMaximumAmount.calculate(
                        1,
                        toIntArray("1")
                )
        );
    }

    @Test
    void calculate2() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("2 2 2"),
                segmentWithMaximumAmount.calculate(
                        2,
                        toIntArray("-1 2")
                )
        );
    }

    @Test
    void calculate3() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("2 5 8"),
                segmentWithMaximumAmount.calculate(
                        5,
                        toIntArray("-1 2 3 -2 5")
                )
        );
    }

    @Test
    void calculate4() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        int n = 100_000;

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = -10_000;
        }
        data[0] = 0;

        int[] expected = new int[3];
        expected[0] = 1;
        expected[1] = 1;
        //expected[2] = 0;

        assertArray(
                expected,
                segmentWithMaximumAmount.calculate(
                        n,
                        data
                )
        );
    }

    @Test
    void calculate5() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("1 1 100"),
                segmentWithMaximumAmount.calculate(
                        8,
                        toIntArray("100 -10 -1  2  3  -2  3  -100")
                )
        );
    }

    @Test
    void calculate6() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("1 7 13"),
                segmentWithMaximumAmount.calculate(
                        8,
                        toIntArray("12 -10 -1 4 4 -2 6 -100")
                )
        );
    }

    @Test
    void calculate7() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("3 3 0"),
                segmentWithMaximumAmount.calculate(
                        5,
                        toIntArray("-1 -2 0 -2 -1")
                )
        );
    }

    @Test
    void calculate8() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("7 13 13"),
                segmentWithMaximumAmount.calculate(
                        14,
                        toIntArray("-1 2 3 -2 5 -100 12 -10 -1 4 4 -2 6 -100")
                )
        );
    }

    @Test
    void calculate9() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("2 8 13"),
                segmentWithMaximumAmount.calculate(
                        14,
                        toIntArray("-1 12 -10 -1 4 4 -2 6 -100 2 3 -2 5 -13 ")
                )
        );
    }

    @Test
    void timeTest() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        int n = 100_000;

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = -1_000;
        }
        for (int i = 0; i < n; i+=4) {
            for (int j = i; j < n && j <= i + 3; j++) {
                data[j] = j % 10000;
            }
        }

        int[] expected = new int[3];
        expected[0] = 1;
        expected[1] = 100_000;
        expected[2] = 499950000;

        assertArray(
                expected,
                segmentWithMaximumAmount.calculate(
                        n,
                        data
                )
        );
    }

    @Test
    void calculate11() {
        SegmentWithMaximumAmount segmentWithMaximumAmount = new SegmentWithMaximumAmount();

        assertArray(
                toIntArray("1 1 -1"),
                segmentWithMaximumAmount.calculate(
                        1,
                        toIntArray("-1")
                )
        );
    }
}