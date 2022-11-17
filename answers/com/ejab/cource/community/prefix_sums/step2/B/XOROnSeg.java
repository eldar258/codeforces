import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class XOROnSeg {
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
        return new XOROnSeg().calculate(n, array, n2, array2);
    }

    public Long[] calculate(Integer n, Integer[] array, Integer countSeg, Integer[][] segments) {
        Integer[] prefixXor = getPrefixXOR(n, array);

        Long[] result = new Long[countSeg];
        for (int i = 0; i < countSeg; i++) {
            Integer[] currentSegment = segments[i];
            result[i] = (long) (prefixXor[currentSegment[1]] ^ prefixXor[currentSegment[0] - 1]);
        }

        return result;
    }

    private Integer[] getPrefixXOR(Integer n, Integer[] array) {
        Integer[] result = new Integer[n + 1];
        result[0] = 0;

        for (int i = 0; i < n; i++) {
            result[i + 1] = array[i] ^ result[i];
        }

        return result;
    }
}
