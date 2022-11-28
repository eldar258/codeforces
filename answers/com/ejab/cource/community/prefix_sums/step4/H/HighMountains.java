import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class HighMountains {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int n2 =  Integer.parseInt(bf.readLine());
        int[][] array2 = new int[n2][];
        for(int i = 0; i < n2; i++) {
            array2[i] = parseArray(new StringTokenizer(bf.readLine()));
        }

        int[] result = calculateResult(n, array, n2, array2);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    public static int[] parseArray(StringTokenizer stringTokenizer) {
        int n = stringTokenizer.countTokens();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        return array;
    }

    public static int[] calculateResult(int n, int[] array, int n2, int[][] array2) {
        return new HighMountains().calculate(n, array, n2, array2);
    }

    public int[] calculate(int n, int[] mountains, int q, int[][] changes) {
        calcPrefixDiff(mountains);

        for (int i = 0; i < q; i++) {
            mountains[n - changes[i][0]] += changes[i][1];
        }

        calcPrefixSum(mountains);

        return mountains;
    }

    private void calcPrefixDiff(int[] mountains) {
        for (int i = mountains.length - 1; i > 0; i--) {
            mountains[i] -= mountains[i - 1];
        }
    }

    private void calcPrefixSum(int[] mountains) {
        for (int i = 1; i < mountains.length; i++) {
            mountains[i] += mountains[i - 1];
        }
    }
}
