package com.ejab.cource.community.prefix_sums.step4.B;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntegerArray;
import static com.ejab.Helper.toLongArray;

import org.junit.jupiter.api.Test;

class AddArithmeticProgressionOnSegmentTest {
    @Test
    public void calculate() {
        AddArithmeticProgressionOnSegment addArithmeticProgressionOnSegment = new AddArithmeticProgressionOnSegment();
        
        assertArray(toLongArray("35"),
                addArithmeticProgressionOnSegment.calculate(
                        1,
                        toIntegerArray("10"),
                        3,
                        toIntegerArray("1 1 40\n"
                                , "1 1 0\n"
                                , "1 1 -15")
                )
        );

        assertArray(toLongArray("30 30 "),
                addArithmeticProgressionOnSegment.calculate(
                        2,
                        toIntegerArray("10 20"),
                        3,
                        toIntegerArray("1 2 6\n"
                                , "1 1 15\n"
                                , "1 2 -1")
                )
        );

        assertArray(toLongArray("5 9 13 20 25"),
                addArithmeticProgressionOnSegment.calculate(
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