import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class PekoraAndTrampolines {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        int[] arraysLengths = new int[t];
        int[][] arrays = new int[t][];
        for (int i = 0; i < t; i++) {
            arraysLengths[i] = Integer.parseInt(bf.readLine());
            arrays[i] = startParseArray(bf);
        }

        long[] result = calculateResult(t, arraysLengths, arrays);

        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        for (var l : result) {
            bos.write(String.valueOf(l).getBytes());
            bos.write(" ".getBytes());
        }

        bos.flush();
    }

    public static int[] startParseArray(BufferedReader bf) throws IOException {
       StringTokenizer st = new StringTokenizer(bf.readLine());

       int[] result = new int[st.countTokens()];
       for (int i = 0; i < result.length; i++) {
          result[i] = Integer.parseInt(st.nextToken());
       }

       return result;
    }

    public static long[] calculateResult(int t, int[] arrayLengths, int[][] arrays) {
        return new PekoraAndTrampolines().calculate(t, arrayLengths, arrays);
    }

    public long[] calculate(int t, int[] arrayLengths, int[][] trampolines) {
        long[] result = new long[t];

        for (int i = 0; i < t; i++) {
            result[i] = calculate(arrayLengths[i], trampolines[i]);
        }

        return result;
    }


    public long calculate(int n, int[] trampolines) {
        long result = 0;
        long[] prefixDiffPekorsClones = new long[n + 3];

        for (int i = 0, j = 1; i < n; i++, j++) {
            prefixDiffPekorsClones[j] += prefixDiffPekorsClones[j - 1];

            long tmp = trampolines[i] - 1 - prefixDiffPekorsClones[j];
            if (tmp > 0) {
                result += tmp;
            } else {
                tmp = -tmp;
                prefixDiffPekorsClones[j + 1] += tmp;
                prefixDiffPekorsClones[j + 2] -= tmp;
            }
            prefixDiffPekorsClones[j + 2] += 1;
            int rightIndex = j + trampolines[i] + 1;
            if (rightIndex < prefixDiffPekorsClones.length) prefixDiffPekorsClones[rightIndex] -= 1;
        }

        return result;
    }
}
