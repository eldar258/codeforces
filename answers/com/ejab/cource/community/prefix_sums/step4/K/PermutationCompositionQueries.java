import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PermutationCompositionQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long[][] result = calculateResult(bf);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            for (var el : l) {
              bos.write(String.valueOf(el).getBytes());
              bos.write(" ".getBytes());
            }
        }

        bos.flush();
    }

    public static long[][] calculateResult(BufferedReader bf) throws IOException {
        return new PermutationCompositionQueries().calculate(bf);
    }

    public long[][] calculate(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        long[][] result = new long[t][];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] array = read2DArray(n, m, br);

            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int[][] requests = read2DArray(q, 2, br);

            result[i] = calculate(array, requests);
        }

        return result;
    }

    public long[] calculate(int[][] array, int[][] requests) {
        int[][] prefixSumPermutation = getPrefixSumPermutation(array);
        int[][] reversesForPrefixSumPermutation = getReversesForPermutation(prefixSumPermutation);

        Map<TwoIntegers, Integer> map = new HashMap<>();

        long[] result = new long[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int l = requests[i][0];
            int r = requests[i][1];

            TwoIntegers integers = new TwoIntegers(l, r);
            Integer value = map.get(integers);
            if (value != null) {
                result[i] = result[value];
            } else {
                int[] b = l == 0 ? prefixSumPermutation[r]
                        : l == r ? array[l]
                                : getPermutation(reversesForPrefixSumPermutation[l - 1], prefixSumPermutation[r]);

                result[i] = getSumByNumber(b);
                map.put(integers, i);
            }
        }

        return result;
    }

    private int[][] getReversesForPermutation(int[][] permutations) {
        int[][] result = new int[permutations.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = getReversePermutation(permutations[i]);
        }

        return result;
    }

    private int[] getReversePermutation(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[a[i]] = i;
        }

        return result;
    }

    private int[][] getPrefixSumPermutation(int[][] array) {
        int[][] result = new int[array.length][];
        result[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            result[i] = getPermutation(result[i - 1], array[i]);
        }

        return result;
    }

    private int[] getPermutation(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = b[a[i]];
        }

        return result;
    }

    private long getSumByNumber(int[] b) {
        long result = 0;
        for (int i = 0; i < b.length; i++) {
            result += (long) (i + 1) * (b[i] + 1);
        }

        return result;
    }

    private int[][] read2DArray(int n, int m, BufferedReader br) throws IOException {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        return result;
    }

    private record TwoIntegers(int l, int r) {}
}
