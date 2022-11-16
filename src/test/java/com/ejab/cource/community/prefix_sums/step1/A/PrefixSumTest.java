package com.ejab.cource.community.prefix_sums.step1.A;

import static com.ejab.Helper.assertArray;
import static com.ejab.Helper.toIntegerArray;
import static com.ejab.Helper.toLongArray;

import org.junit.jupiter.api.Test;

public class PrefixSumTest {

    @Test
    public void testCalculate() {
        PrefixSum prefixSum = new PrefixSum();
        assertArray(new Long[]{0L, 178L},
                prefixSum.calculate(1, new Integer[]{178,})
        );
        assertArray(new Long[]{0L, 0L, 1L, 3L, 6L, 10L, 15L, 21L },
                prefixSum.calculate(7, new Integer[]{0, 1, 2, 3, 4, 5, 6})
        );
        assertArray(toLongArray("0 -1 -3 0 0 4"),
                prefixSum.calculate(5, toIntegerArray("-1 -2 3 0 4"))
        );
    }
}