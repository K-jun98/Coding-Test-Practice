package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ2295 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (set.contains(arr[i] - arr[j])) {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        System.out.println(max);
    }
}
