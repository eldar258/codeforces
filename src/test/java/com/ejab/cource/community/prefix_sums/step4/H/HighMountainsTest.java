package com.ejab.cource.community.prefix_sums.step4.H;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntArray;

import org.junit.jupiter.api.Test;

class HighMountainsTest {

    @Test
    void calculate() {
        HighMountains highMountains = new HighMountains();

        assertArray(
                toIntArray("1000 4000 8000"),
                highMountains.calculate(
                        3,
                        toIntArray("1000 2000 3000"),
                        2,
                        toIntArray("2 2000\n"
                                , "1 3000")
                )
        );
    }
}