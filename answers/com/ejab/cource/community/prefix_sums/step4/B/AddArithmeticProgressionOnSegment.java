import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class AddArithmeticProgressionOnSegment {
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
        return new AddArithmeticProgressionOnSegment().calculate(n, array, n2, array2);
    }

    public Long[] calculate(Integer n, Integer[] array, Integer q, Integer[][] segmentsAndValues) {
        Long[] result = new Long[n];
        for (int i = 0; i < n; i++) {
            result[i] = (long) array[i];
        }

        calcPrefixDiff(n, result);
        calcPrefixDiff(n, result);
        for (int i = 0; i < q; i++) {
            addOnSegments(result, segmentsAndValues[i][0], segmentsAndValues[i][1], segmentsAndValues[i][2]);
        }
        calcPrefixSum(n, result);
        calcPrefixSum(n, result);

        return result;
    }

    private void addOnSegments(Long[] result, Integer start, Integer end, Integer value) {
        start--;
        result[start] += value;
        if (end != result.length) {
            result[end] -= (long) (end - start + 1) * value;
        } else return;
        if (end + 1 != result.length) result[end + 1] += (long) (end - start) * value;
    }

    private void calcPrefixSum(Integer n, Long[] result) {
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }
    }

    private void calcPrefixDiff(Integer n, Long[] result) {
        for (int i = n - 1; i >= 1; i--) {
            result[i] -= result[i - 1];
        }
    }
}
