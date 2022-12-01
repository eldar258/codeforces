package com.ejab.cource.community.prefix_sums.step4.J;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class DesignDecisionTest {

    @Test
    void calculate() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        assertEquals(
                9,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        8 3 5
                        1 5 60 58 61 11 27 25
                        """)))
        );
    }

    @Test
    void calculate2() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        int k = 2;
        assertEquals(
                1_000_000 - k + 1,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        1 2 2
                        1
                        """)))
        );
    }

    @Test
    void calculate3() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        assertEquals(
                1,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        5 0 5
                        1 2 3 4 5
                        """)))
        );
    }

    @Test
    void calculate4() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        assertEquals(
                5,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        5 0 1
                        1 2 3 4 5
                        """)))
        );
    }

    @Test
    void calculate5() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        assertEquals(
                1,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        1 0 1
                        1
                        """)))
        );
    }

    @Test
    void calculate6() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        assertEquals(
                9,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        10 1 3
                        1 3 5 7 9 11 13 15 17 19
                        """)))
        );
    }

    @Test
    void calculate7() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        assertEquals(
                1,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        1 2 3
                        1000000
                        """)))
        );
    }

    @Test
    void calculate8() throws IOException {
        DesignDecision designDecision = new DesignDecision();

        assertEquals(
                0,
                designDecision.calculate(new BufferedReader(new StringReader("""
                        1 10000 1000000
                        1
                        """)))
        );
    }
}