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
        long[] pekorsClones = new long[n];

        for (int i = 0; i < n; i++) {
            int si = trampolines[i];
            long howManyPekorsNeedTake = Math.max(si - 1 - pekorsClones[i], 0);
            pekorsClones[i] += howManyPekorsNeedTake;
            result += howManyPekorsNeedTake;

            if (pekorsClones[i] > 0) { // Pekors clones will jump to other positions to right
                int maxIndexPositionWherePekorCanJump = Math.min(n - 1, si + i);
                for (int j = i + 2; j <= maxIndexPositionWherePekorCanJump; j++) {
                    pekorsClones[j] += 1; // new place of this Pekors clones
                }

                if (i + 1 < n) {
                    long howManyPekorsClonesAreLeftAfterJumping = pekorsClones[i] - (si - 1);
                    pekorsClones[i + 1] += howManyPekorsClonesAreLeftAfterJumping; // Jump to next position, because S == 1
                }
            }

        }
        return result;
    }
}
