package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];
        arr = Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::valueOf).toArray();
        Arrays.sort(arr);

        long resultValue = Long.MAX_VALUE;
        long[] resultSolutions = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < resultValue) {
                    resultValue = Math.abs(sum);
                    resultSolutions[0] = arr[i];
                    resultSolutions[1] = arr[left];
                    resultSolutions[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        Arrays.sort(resultSolutions);
        System.out.print(resultSolutions[0] + " " + resultSolutions[1] + " " + resultSolutions[2]);
    }
}
