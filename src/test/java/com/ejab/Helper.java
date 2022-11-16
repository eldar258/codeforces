package com.ejab;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.opentest4j.AssertionFailedError;

public class Helper {
    public static void assertArray(Object[] expected, Object[] result) {
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

    public static Long[][] toLongArray(String... text) {
        Long[][] result = new Long[text.length][];
        for (int i = 0; i < text.length; i++) {
            result[i] = toLongArray(text[i]);
        }
        return result;
    }

    public static Integer[][] toIntegerArray(String... text) {
        Integer[][] result = new Integer[text.length][];
        for (int i = 0; i < text.length; i++) {
            result[i] = toIntegerArray(text[i]);
        }
        return result;
    }

    public static Integer[] toIntegerArray(String text) {
        return Arrays.stream(text.trim().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public static Long[] toLongArray(String text) {
        return Arrays.stream(text.trim().split("[ \n]+")).map(Long::parseLong).toArray(Long[]::new);
    }
}
