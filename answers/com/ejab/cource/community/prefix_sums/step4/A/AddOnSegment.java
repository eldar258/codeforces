import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class AddOnSegment {
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
        return new AddOnSegment().calculate(n, array, n2, array2);
    }

    public Long[] calculate(Integer n, Integer[] array, Integer q, Integer[][] segmentsAndValues) {
        Long[] result = new Long[n];
        for (int i = 0; i < n; i++) {
            result[i] = (long) array[i];
        }

        calcPrefixDiff(result);
        for (int i = 0; i < q; i++) {
            addOnSegment(result, segmentsAndValues[i][0], segmentsAndValues[i][1], segmentsAndValues[i][2]);
        }
        calcPrefixSum(result);

        return result;
    }

    private void calcPrefixSum(Long[] result) {
        for (int i = 1; i < result.length; i++) {
            result[i] +=result[i - 1];
        }
    }

    private void calcPrefixDiff(Long[] result) {
        for (int i = result.length - 1; i >= 1; i--) {
            result[i] -= result[i - 1];
        }
    }

    private void addOnSegment(Long[] result, Integer start, Integer end, Integer value) {
            result[start - 1] += value;
            if (end != result.length) result[end] -= value;
    }
}
