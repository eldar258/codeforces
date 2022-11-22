import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class AddOnRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Integer[][] array1 = startParseTwoDArray(bf);
        int n1 = array1.length;
        int m1 = array1[0].length;

        Integer[][] array2 = startParseTwoDArray(bf);
        int n2 = array2.length;
        int m2 = array2[0].length;

        Long[][] result = calculateResult(n1, m1, array1, n2, m2, array2);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            for (var el : l) {
                bos.write(String.valueOf(el).getBytes());
                bos.write(" ".getBytes());
            }
            bos.write("\n".getBytes());
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

    public static Long[][] calculateResult(Integer n1, Integer m1, Integer[][] array1, Integer n2, Integer m2, Integer[][] array2) {
        return new AddOnRectangle().calculate(n1, m1, array1, n2, array2);
    }

    public Long[][] calculate(Integer n, Integer m, Integer[][] array, Integer q, Integer[][] rectangles) {
        Long[][] result = new Long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (long) array[i][j];
            }
        }

        calcPrefixDiff2D(n, m, result);
        for (int i = 0; i < q; i++) {
            addOnRectangle(n, m, result, rectangles[i][0], rectangles[i][1], rectangles[i][2], rectangles[i][3], rectangles[i][4]);
        }
        calcPrefixSum2D(n, m, result);

        return result;
    }

    private void addOnRectangle(Integer n, Integer m, Long[][] result, int lx, int ly, int rx, int ry, int value) {
        lx--;
        ly--;
        result[lx][ly] += value;
        if (rx != n) result[rx][ly] -= value;
        if (ry != m) result[lx][ry] -= value;
        if (rx != n && ry != m) result[rx][ry] += value;
    }

    private void calcPrefixSum2D(Integer n, Integer m, Long[][] result) {
        for (int i = 0; i < n; i++) {
            calcPrefixSum(result[i]);
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                result[i][j] += result[i - 1][j];
            }
        }
    }

    private void calcPrefixSum(Long[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }

    private void calcPrefixDiff2D(Integer n, Integer m, Long[][] result) {
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 1; i--) {
                result[i][j] -= result[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            calcPrefixDiff(result[i]);
        }
    }

    private void calcPrefixDiff(Long[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            array[i] -= array[i - 1];
        }
    }
}
