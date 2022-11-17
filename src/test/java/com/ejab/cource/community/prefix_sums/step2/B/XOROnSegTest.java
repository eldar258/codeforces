package com.ejab.cource.community.prefix_sums.step2.B;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntegerArray;
import static com.ejab.Helper.toLongArray;

import org.junit.jupiter.api.Test;

class XOROnSegTest {

    @Test
    public void calculate() {
        XOROnSeg xorOnSeg = new XOROnSeg();

        assertArray(toLongArray("""
                        12
                        6
                        10"""),
                xorOnSeg.calculate(
                2,
                toIntegerArray("12 6"),
                3,
                toIntegerArray("1 1\n"
                        , "2 2\n"
                        , "1 2")
                )
        );

        assertArray(toLongArray("""
                        4
                        3
                        0
                        3
                        5"""),
                xorOnSeg.calculate(
                        5,
                        toIntegerArray("1 2 3 0 4"),
                        5,
                        toIntegerArray("1 5\n"
                                , "1 2\n"
                                , "4 4\n"
                                , "3 4\n"
                                , "2 5")
                )
        );

        assertArray(toLongArray("""
                        1
                        1
                        0
                        0
                        1
                        1
                        1
                        0
                        1"""),
                xorOnSeg.calculate(
                        7,
                        toIntegerArray("1 1 1 1 1 1 1"),
                        9,
                        toIntegerArray("1 7\n"
                                , "2 6\n"
                                , "3 4\n"
                                , "2 5\n"
                                , "5 7\n"
                                , "6 6\n"
                                , "3 3\n"
                                , "2 7\n"
                                , "1 1")
                )
        );
    }
}