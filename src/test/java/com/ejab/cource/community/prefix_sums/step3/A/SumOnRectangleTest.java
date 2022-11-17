package com.ejab.cource.community.prefix_sums.step3.A;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntegerArray;
import static com.ejab.Helper.toLongArray;

import org.junit.jupiter.api.Test;

class SumOnRectangleTest {

    @Test
    public void calculate() {
        SumOnRectangle sumOnRectangle = new SumOnRectangle();

        assertArray(toLongArray("104"),
                sumOnRectangle.calculate(
                        1, 1,
                        new Integer[][]{{104}},
                        1,
                        new Integer[][]{toIntegerArray("1 1 1 1")}
                ));

        assertArray(toLongArray("""
                        1
                        3
                        5
                        15
                        2
                        4
                        8"""),
                sumOnRectangle.calculate(
                        2, 2,
                        toIntegerArray("1 2\n"
                                , "4 8"),
                        7,
                        toIntegerArray("1 1 1 1\n"
                                , "1 1 1 2\n"
                                , "1 1 2 1\n"
                                , "1 1 2 2\n"
                                , "1 2 1 2\n"
                                , "2 1 2 1\n"
                                , "2 2 2 2")
                ));


        assertArray(toLongArray("""
                        -3
                        -5
                        15
                        -12
                        -7"""),
                sumOnRectangle.calculate(
                        3, 3,
                        toIntegerArray("1 2 3\n"
                                , "-4 -5 -6\n"
                                , "7 8 -9"),
                        5,
                        toIntegerArray("1 1 3 3\n"
                                , "2 2 2 2\n"
                                , "3 1 3 2\n"
                                , "1 3 3 3\n"
                                , "1 2 3 3")
                ));
    }
}