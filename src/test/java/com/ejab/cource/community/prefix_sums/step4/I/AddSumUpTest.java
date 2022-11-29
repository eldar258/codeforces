package com.ejab.cource.community.prefix_sums.step4.I;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class AddSumUpTest {

    @Test
    void calculate() throws IOException {
        AddSumUp addSumUp = new AddSumUp();

        assertEquals(
                25,
                addSumUp.calculate(new BufferedReader(new StringReader("""
                        5 5
                        0 257
                        """
                )))
        );
    }

    @Test
    void calculate2() throws IOException {
        AddSumUp addSumUp = new AddSumUp();

        assertEquals(
                811747796L,
                addSumUp.calculate(new BufferedReader(new StringReader("""
                        5 5
                        13 239
                        """
                )))
        );
    }

    @Test
    void calculate3() throws IOException {
        AddSumUp addSumUp = new AddSumUp();

        assertEquals(
                3460675938L,
                addSumUp.calculate(new BufferedReader(new StringReader("""
                        10 10
                        239017 170239
                        """
                )))
        );
    }

    @Test
    void calculate4() throws IOException {
        AddSumUp addSumUp = new AddSumUp();

        assertEquals(
                75,
                addSumUp.calculate(new BufferedReader(new StringReader("""
                        5 5
                        0 1000
                        """
                )))
        );
    }

    @Test
    void testD() throws IOException {
        AddSumUp addSumUp = new AddSumUp();

        addSumUp.calculate(new BufferedReader(new StringReader("""
                        1677721 1677721
                        9999999 9999999
                        """
        )));
    }
}