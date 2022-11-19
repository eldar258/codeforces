package com.ejab.cource.community.prefix_sums.step3.B;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toLongArray;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class SumOn5DTest {

    @Test
    void calculate1() throws IOException {
        SumOn5D sumOn5d = new SumOn5D();

        assertArray(toLongArray("17"),
                sumOn5d.calculate("""
                        1 1 1 1 1
                        17
                        1
                        1 1 1 1 1 1 1 1 1 1
                        """)
        );
    }

    @Test
    void calculate2() throws IOException {
        SumOn5D sumOn5d = new SumOn5D();

        assertArray(toLongArray("""
                        1
                        32
                        1"""),
                sumOn5d.calculate("""
                        2 2 2 2 2
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        1 1
                        3
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 2 2 2 2 2
                        1 2 1 2 1 1 2 1 2 1
                        """)
        );
    }

    @Test
    void calculate3() throws IOException {
        SumOn5D sumOn5d = new SumOn5D();

        assertArray(toLongArray("""
                        1
                        528
                        11"""),
                sumOn5d.calculate("""
                        2 2 2 2 2
                        1 2
                        3 4
                        5 6
                        7 8
                        9 10
                        11 12
                        13 14
                        15 16
                        17 18
                        19 20
                        21 22
                        23 24
                        25 26
                        27 28
                        29 30
                        31 32
                        3
                        1 1 1 1 1 1 1 1 1 1
                        1 1 1 1 1 2 2 2 2 2
                        1 2 1 2 1 1 2 1 2 1
                        """)
        );
    }

    @Test
    void calculate$() throws IOException {
        SumOn5D sumOn5d = new SumOn5D();
        sumOn5d.calculate("""
                1 2 3 4 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1 2 3 4 5 6 7 8 9 10
                1
                1 1 1 1 1 1 1 1 1 1
                """);
    }
}