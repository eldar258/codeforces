import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


import java.util.Arrays;

public class SumOnRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Integer[][] array1 = startParseTwoDArray(bf);
        int n1 = array1.length;
        int m1 = array1[0].length;

        Integer[][] array2 = startParseTwoDArray(bf);
        int n2 = array2.length;
        int m2 = array2[0].length;

        Long[] result = calculateResult(n1, m1, array1, n2, m2, array2);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    public static Integer[][] startParseTwoDArray(BufferedReader bf) throws IOException {
       StringTokenizer st = new StringTokenizer(bf.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m;
       if (st.hasMoreTokens()) {
           m = Integer.parseInt(st.nextToken());
           st = new StringTokenizer(bf.readLine());
       } else {
          st = new StringTokenizer(bf.readLine());
          m = st.countTokens();
       }

       Integer[][] result = new Integer[n][m];
       for (int i = 0; i < n - 1; i++) {
          for (int j = 0; j < m; j++) {
              result[i][j] = Integer.parseInt(st.nextToken());
          }
          st = new StringTokenizer(bf.readLine());
       }
       for (int j = 0; j < m; j++) {
          result[n - 1][j] = Integer.parseInt(st.nextToken());
       }

       return result;
    }

    public static Long[] calculateResult(Integer n1, Integer m1, Integer[][] array1, Integer n2, Integer m2, Integer[][] array2) {
        return new SumOnRectangle().calculate(n1, m1, array1, n2, array2);
    }

    public Long[] calculate(Integer n, Integer m, Integer[][] array1, Integer q, Integer[][] array2) {
        Long[][] prefix2D = getPrefix2D(n, m, array1);

        Long[] result = new Long[q];
        for (int i = 0; i < q; i++) {
            int lx = array2[i][0];
            int ly = array2[i][1];
            int rx = array2[i][2];
            int ry = array2[i][3];

            long lu = prefix2D[lx - 1][ly - 1];
            long ru = prefix2D[lx - 1][ry];
            long ld = prefix2D[rx][ly - 1];
            long rd = prefix2D[rx][ry];

            result[i] = rd - ru - ld + lu;
        }

        return result;
    }

    private Long[][] getPrefix2D(Integer n, Integer m, Integer[][] array) {
        Long[][] prefixSumRows = new Long[n][];
        for (int i = 0; i < n; i++) {
            prefixSumRows[i] = getPrefixSum(m, array[i]);
        }

        Long[][] result = new Long[n + 1][m + 1];
        for (var el : result) {
            Arrays.fill(el, 0L);
        }
        for (int j = 1; j < m + 1; j++) {
            for (int i = 0; i < n; i++) {
                result[i + 1][j] = prefixSumRows[i][j] + result[i][j];
            }
        }

        return result;
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
