package com.ejab.cource.community.prefix_sums.step4.A;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntegerArray;
import static com.ejab.Helper.toLongArray;

import org.junit.jupiter.api.Test;

class AddOnSegmentTest {

    @Test
    public void calculate() {
        AddOnSegment addOnSegment = new AddOnSegment();
        assertArray(toLongArray("127"),
                addOnSegment.calculate(
                        1,
                        toIntegerArray("100"),
                        3,
                        toIntegerArray("1 1 10\n"
                                , "1 1 -3\n"
                                , "1 1 20")
                )
        );

        assertArray(toLongArray("-10 -120 "),
                addOnSegment.calculate(
                        2,
                        toIntegerArray("0 0"),
                        5,
                        toIntegerArray("1 1 100\n"
                                , "1 2 -100\n"
                                , "2 2 10\n"
                                , "1 1 20\n"
                                , "1 2 -30")
                )
        );

        assertArray(toLongArray("5 5 6 8 9 "),
                addOnSegment.calculate(
                        5,
                        toIntegerArray("1 2 3 4 -5"),
                        3,
                        toIntegerArray("5 5 10\n"
                                , "1 5 4\n"
                                , "2 3 -1")
                )
        );
    }
}