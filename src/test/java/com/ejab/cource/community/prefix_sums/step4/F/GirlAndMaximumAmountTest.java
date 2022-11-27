package com.ejab.cource.community.prefix_sums.step4.F;

import static com.ejab.Helper.assertArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class GirlAndMaximumAmountTest {

    @Test
    void calculate() throws IOException {
        GirlAndMaximumAmount girlAndMaximumAmount = new GirlAndMaximumAmount();

        assertArray(new long[]{25},
                girlAndMaximumAmount.calculate(new BufferedReader(new StringReader("""
                        3 3
                        5 3 2
                        1 2
                        2 3
                        1 3
                        """
                )))
        );
    }

    @Test
    void calculate2() throws IOException {
        GirlAndMaximumAmount girlAndMaximumAmount = new GirlAndMaximumAmount();

        assertArray(new long[]{33},
                girlAndMaximumAmount.calculate(new BufferedReader(new StringReader("""
                        5 3
                        5 2 4 1 3
                        1 5
                        2 3
                        2 3
                        """
                )))
        );
    }
}