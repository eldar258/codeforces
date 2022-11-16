import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bf.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Long[] result = calculateResult(n, array);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    public static Long[] calculateResult(Integer n, Integer[] array) {
        return new PrefixSum().calculate(n, array);
    }

    public Long[] calculate(Integer n, Integer[] array) {
        Long[] result = new Long[n + 1];
        result[0] = 0L;
        for (int i = 0; i < n; i++) {
            result[i + 1] = result[i] + array[i];
        }
        return result;
    }
}
