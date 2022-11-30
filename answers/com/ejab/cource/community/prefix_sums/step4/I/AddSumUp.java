import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AddSumUp {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long result = calculateResult(bf);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        bos.write(String.valueOf(result).getBytes());

        bos.flush();
    }

    public static long calculateResult(BufferedReader bf) throws IOException {
        return new AddSumUp().calculate(bf);
    }

    public long calculate(BufferedReader bf) throws IOException {
        int n = (int) Math.pow(2, 24);
        long[] array = new long[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Generator generator = new Generator(a, b);

        while (m > 0) {
            m--;
            int[] lrv = generator.nextFirstType();

            array[lrv[0]] += lrv[2];
            if (lrv[1] + 1 < n) array[lrv[1] + 1] -= lrv[2];
        }

        calcPrefixSum(array);
        calcPrefixSum(array);

        long result = 0;
        while (q > 0) {
            q--;
            int[] lr = generator.nextSecondType();

            long lastSum = (lr[0] - 1 >= 0) ? array[lr[0] - 1] : 0;
            result += array[lr[1]] - lastSum;
        }

        return Long.remainderUnsigned(result, (long) Math.pow(2, 32));
    }

    private void calcPrefixSum(long[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }

    private static class Generator {
        private final int a;
        private final int b;

        int cur = 0;

        private Generator(int a, int b) {
            this.a = a;
            this.b = b;
        }

        private int nextRand() {
            cur = cur * a + b;
            return cur >>> 8;
        }

        public int[] nextFirstType() {
            int[] result = new int[3];
            result[2] = nextRand();
            int l = nextRand();
            int r = nextRand();
            addAndReturn(result, l, r);
            return result;
        }

        public int[] nextSecondType() {
            int[] result = new int[2];
            int l = nextRand();
            int r = nextRand();
            addAndReturn(result, l, r);
            return result;
        }

        private void addAndReturn(int[] result, int l, int r) {
            if (l > r) {
                result[0] = r;
                result[1] = l;
            } else {
                result[0] = l;
                result[1] = r;
            }
        }
    }
}
