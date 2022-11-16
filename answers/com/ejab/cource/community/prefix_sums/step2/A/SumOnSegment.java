import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class SumOnSegment {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bf.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Integer n2 =  Integer.parseInt(bf.readLine());
        Integer[][] array2 = new Integer[n2][];
        for(int i = 0; i < n2; i++) {
            array2[i] = parseArray(new StringTokenizer(bf.readLine()));
        }

        Long[] result = calculateResult(n, array, n2, array2);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    public static Integer[] parseArray(StringTokenizer stringTokenizer) {
        int n = stringTokenizer.countTokens();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return array;
    }

    public static Long[] calculateResult(Integer n, Integer[] array, Integer n2, Integer[][] array2) {
        return new SumOnSegment().calculate(n, array, n2, array2);
    }

    public Long[] calculate(Integer n, Integer[] array, Integer seqNum, Integer[][] sequence) {
        Long[] prefixSum = getPrefixSum(n, array);

        Long[] result = new Long[seqNum];

        for (int i = 0; i < seqNum; i++) {
            result[i] = getSum(prefixSum, sequence[i]);
        }

        return result;
    }

    private Long getSum(Long[] prefixSum, Integer[] integers) {
        int il = integers[0];
        int ir = integers[1];

        return prefixSum[ir] - prefixSum[il - 1];
    }

    private Long[] getPrefixSum(Integer n, Integer[] array) {
        Long[] result = new Long[n + 1];
        result[0] = 0L;

        for (int i = 0; i < n; i++) {
            result[i + 1] = array[i] + result[i];
        }

        return result;
    }
}
