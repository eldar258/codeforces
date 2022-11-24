package com.ejab.cource.community.prefix_sums.step4.D;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntArray;
import static com.ejab.Helper.toLArray;

import org.junit.jupiter.api.Test;

class PekoraAndTrampolinesTest {

    @Test
    public void calculate() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();

        assertArray(toLArray("""
                        4
                        3
                        0""")
                ,
                pekoraAndTrampolines.calculate(
                        3,
                        new int[]{7, 2, 5},
                        toIntArray("1 4 2 2 2 2 2", "2 3", "1 1 1 1 1")
                )
        );
    }

    @Test
    public void calculate2() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();

        assertArray(toLArray("9")
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{7},
                        new int[][]{{1, 4, 3, 1, 1, 1, 10}}
                )
        );
    }

    @Test
    public void calculate3() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int n = 5000;
        int[][] data = new int[1][n];
        for (int i = 0; i < n; i++) {
            data[0][i] = n - i;
        }
        int expected = -1; // 4999 + 4999 + 4997 + 4996...
        for (int i = 0; i < n; i++) {
            expected += Math.max(data[0][i] - i, 0);
        }
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate4() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 0;
        int n = 1;
        int[][] data = new int[][]{{1}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate5() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 1;
        int n = 1;
        int[][] data = new int[][]{{2}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate6() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 10;
        int n = 3;
        int[][] data = new int[][]{{1, 2, 10}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate7() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 9;
        int n = 3;
        int[][] data = new int[][]{{2, 1, 10}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate8() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 18;
        int n = 3;
        int[][] data = new int[][]{{11, 1, 10}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate9() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 37;
        int n = 3;
        int[][] data = new int[][]{{11, 20, 10}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate10() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 16;
        int n = 3;
        int[][] data = new int[][]{{4, 13, 3}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate11() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        int expected = 26;
        int n = 6;
        int[][] data = new int[][]{{4, 13, 3, 4, 13, 3}};
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }

    @Test
    public void calculate12() {
        PekoraAndTrampolines pekoraAndTrampolines = new PekoraAndTrampolines();
        long expected = 999_999_999L + 999_999_999L + 999_999_998L + 999_999_997L + 999_999_996L;
        int n = 5000;
        int[][] data = new int[1][n];
        data[0][0] = 1_000_000_000;
        data[0][1] = 1_000_000_000;
        data[0][2] = 1_000_000_000;
        data[0][3] = 1_000_000_000;
        data[0][4] = 1_000_000_000;
        for (int i = 5; i < n; i++) {
            data[0][i] = 1;
        }
        assertArray(new long[]{expected}
                ,
                pekoraAndTrampolines.calculate(
                        1,
                        new int[]{n},
                        data
                )
        );
    }
}