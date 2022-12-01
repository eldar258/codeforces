import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DesignDecision {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long result = calculateResult(bf);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        bos.write(String.valueOf(result).getBytes());

        bos.flush();
    }

    public static long calculateResult(BufferedReader bf) throws IOException {
        return new DesignDecision().calculate(bf);
    }

    public long calculate(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (m >= k) return 1_000_000 - k + 1;

        int[] array = new int[1_000_000 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            array[index] = 1;
        }

        calcPrefixSum(array);

        long result = 0;
        for (int i = k; i < array.length; i++) {
            if (array[i] - array[i - k] + m >= k) result++;
        }

        return result;
    }

    private void calcPrefixSum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }
}
