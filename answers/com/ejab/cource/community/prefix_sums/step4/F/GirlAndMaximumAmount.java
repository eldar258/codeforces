import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GirlAndMaximumAmount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long[] result = calculateResult(bf);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    public static long[] calculateResult(BufferedReader bf) throws IOException {
        return new GirlAndMaximumAmount().calculate(bf);
    }

    public long[] calculate(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[][] requests = new int[q][];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int count = st.countTokens();
            requests[i] = new int[count];
            for (int j = 0; j < count; j++) {
                requests[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return new long[]{calculate(n, q, array, requests)};
    }

    private long calculate(int n, int q, int[] array, int[][] requests) {
        int[] collectRequests = new int[n];
        for (int i = 0; i < q; i++) {
            calcCollect(requests[i][0], requests[i][1], n, collectRequests);
        }

        calcPrefixSum(n, collectRequests);
        Arrays.sort(array);
        Arrays.sort(collectRequests);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += ((long) array[i]) * collectRequests[i];
        }

        return result;
    }

    private void calcPrefixSum(int n, int[] collectRequests) {
        for (int i = 1; i < n; i++) {
            collectRequests[i] += collectRequests[i - 1];
        }
    }

    private void calcCollect(int startIndex, int endIndex, int n, int[] collectRequests) {
        collectRequests[startIndex - 1] += 1;
        if (endIndex < n) collectRequests[endIndex] -= 1;
    }
}
