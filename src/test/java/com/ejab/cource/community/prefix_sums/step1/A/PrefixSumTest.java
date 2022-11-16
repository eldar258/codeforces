package com.ejab.cource.community.prefix_sums.step1.A;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

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

    private Long[] toLongArray(String text) {
        return Arrays.stream(text.split(" ")).map(Long::parseLong).toArray(Long[]::new);
    }
    private Integer[] toIntegerArray(String text) {
        return Arrays.stream(text.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public void assertArray(Object[] expected, Object[] result) {
        try {
            assertArrayEquals(expected, result);
        } catch (AssertionFailedError assertionFailedError) {
            printArrayFirst100(expected);
            printArrayFirst100(result);
            throw assertionFailedError;
        }
    }

    public static <A> void printArrayFirst100(A[] array) {
        Arrays.stream(array).limit(100).forEach(el -> System.out.printf("[%-2s],", el));
        System.out.println();
    }
}