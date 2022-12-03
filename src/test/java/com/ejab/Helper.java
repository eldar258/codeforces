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

    public static void printArrayFirst100(Object[] array) {
        Arrays.stream(array).limit(100).forEach(el -> {
            if (el instanceof Object[]) printArrayFirst100((Object[]) el);
            else if (el instanceof int[]) printArrayFirst100((int[]) el);
            else if (el instanceof long[]) printArrayFirst100((long[]) el);
            else System.out.printf("[%-2s],", el);
        });
        System.out.println();
    }

    public static void assertArray(int[] expected, int[] result) {
        try {
            assertArrayEquals(expected, result);
        } catch (AssertionFailedError assertionFailedError) {
            printArrayFirst100(expected);
            printArrayFirst100(result);
            throw assertionFailedError;
        }
    }

    public static void assertArray(long[] expected, long[] result) {
        try {
            assertArrayEquals(expected, result);
        } catch (AssertionFailedError assertionFailedError) {
            printArrayFirst100(expected);
            printArrayFirst100(result);
            throw assertionFailedError;
        }
    }


    public static void printArrayFirst100(int[] array) {
        Arrays.stream(array).limit(100).forEach(el -> System.out.printf("[%-2s],", el));
        System.out.println();
    }

    public static void printArrayFirst100(long[] array) {
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
        return Arrays.stream(text.trim().split("[ \n]+")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public static int[][] toIntArray(String... text) {
        int[][] result = new int[text.length][];
        for (int i = 0; i < text.length; i++) {
            result[i] = toIntArray(text[i]);
        }
        return result;
    }

    public static int[] toIntArray(String text) {
        var result = toIntegerArray(text);
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    public static long[] toLArray(String text) {
        var result = toLongArray(text);
        return Arrays.stream(result).mapToLong(Long::longValue).toArray();
    }

    public static Long[] toLongArray(String text) {
        return Arrays.stream(text.trim().split("[ \n]+")).map(Long::parseLong).toArray(Long[]::new);
    }
}
