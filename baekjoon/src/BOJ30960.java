import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ30960 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        long minAwkwardness = Long.MAX_VALUE;

        // Consider every possible way to place the group of 3
        for (int start = 0; start <= N - 3; start++) {
            long awkwardnessSum = 0;
            // Calculate awkwardness for the group of 3
            awkwardnessSum += A[start + 2] - A[start];

            // Calculate awkwardness for pairs before the group of 3
            for (int i = 0; i < start; i += 2) {
                awkwardnessSum += A[i + 1] - A[i];
            }

            // Calculate awkwardness for pairs after the group of 3
            for (int i = start + 3; i < N; i += 2) {
                if (i + 1 < N) { // Ensure not going out of bounds
                    awkwardnessSum += A[i + 1] - A[i];
                }
            }

            // Keep track of the minimal awkwardness
            minAwkwardness = Math.min(minAwkwardness, awkwardnessSum);
        }

        System.out.println(minAwkwardness);
        scanner.close();
    }
}
