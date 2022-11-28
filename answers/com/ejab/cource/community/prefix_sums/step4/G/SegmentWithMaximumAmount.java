import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SegmentWithMaximumAmount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] result = calculateResult(n, array);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    public static int[] calculateResult(int n, int[] array) {
        return new SegmentWithMaximumAmount().calculate(n, array);
    }

    public int[] calculate(int n, int[] array) {
        int result = array[0];
        int lIndex = 0;
        int rIndex = 0;
        int sum = 0;
        int minusPos = -1;

        for (int i = 0; i < n; i++) {
            sum += array[i];
            if (sum > result) {
                result = sum;
                lIndex = minusPos + 1;
                rIndex = i;
            }
            if (sum < 0) {
                sum = 0;
                minusPos = i;
            }
        }

        return new int[]{lIndex + 1, rIndex + 1, result};
    }
}
