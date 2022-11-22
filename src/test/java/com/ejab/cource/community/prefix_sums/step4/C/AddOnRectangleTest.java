package com.ejab.cource.community.prefix_sums.step4.C;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntegerArray;
import static com.ejab.Helper.toLongArray;

import org.junit.jupiter.api.Test;

class AddOnRectangleTest {

    @Test
    void calculate1() {
        AddOnRectangle addOnRectangle = new AddOnRectangle();

        assertArray(
                new Long[][]{{108L}},
                addOnRectangle.calculate(
                        1, 1,
                        new Integer[][]{{10}},
                        3,
                        toIntegerArray("1 1 1 1 100\n"
                                , "1 1 1 1 1\n"
                                , "1 1 1 1 -3")
                )
        );
    }

    @Test
    void calculate2() {
        AddOnRectangle addOnRectangle = new AddOnRectangle();

        assertArray(
                toLongArray("9 9 \n"
                        , "-3 5 "),
                addOnRectangle.calculate(
                        2, 2,
                        toIntegerArray("0 0\n"
                                , "0 0"),
                        3,
                        toIntegerArray("1 1 2 2 5\n"
                                , "1 1 1 2 4\n"
                                , "2 1 2 1 -8")
                )
        );
    }

    @Test
    void calculate3() {
        AddOnRectangle addOnRectangle = new AddOnRectangle();

        assertArray(
                toLongArray("6 5 6 \n"
                        , "9 8 9 \n"
                        , "12 13 14 "),
                addOnRectangle.calculate(
                        3, 3,
                        toIntegerArray(
                                "1 2 3\n"
                                , "4 5 6\n"
                                , "7 8 -9"),
                        3,
                        toIntegerArray("3 3 3 3 18\n"
                                , "1 1 3 3 5\n"
                                , "1 2 2 3 -2")
                )
        );
    }
}