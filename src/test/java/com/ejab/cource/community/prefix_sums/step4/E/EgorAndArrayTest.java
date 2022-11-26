package com.ejab.cource.community.prefix_sums.step4.E;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toLArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class EgorAndArrayTest {

    @Test
    public void calculate() throws IOException {
        EgorAndArray egorAndArray = new EgorAndArray();

        assertArray(
                toLArray("9 18 17"),
                egorAndArray.calculate(new BufferedReader(new StringReader("""
                        3 3 3
                        1 2 3
                        1 2 1
                        1 3 2
                        2 3 4
                        1 2
                        1 3
                        2 3
                        """
                )))
        );
    }

    @Test
    public void calculate2() throws IOException {
        EgorAndArray egorAndArray = new EgorAndArray();

        assertArray(
                toLArray("2"),
                egorAndArray.calculate(new BufferedReader(new StringReader("""
                        1 1 1
                        1
                        1 1 1
                        1 1
                        """
                )))
        );
    }

    @Test
    public void calculate3() throws IOException {
        EgorAndArray egorAndArray = new EgorAndArray();

        assertArray(
                toLArray("5 18 31 20"),
                egorAndArray.calculate(new BufferedReader(new StringReader("""
                        4 3 6
                        1 2 3 4
                        1 2 1
                        2 3 2
                        3 4 4
                        1 2
                        1 3
                        2 3
                        1 2
                        1 3
                        2 3
                        """
                )))
        );
    }
}