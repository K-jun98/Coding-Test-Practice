import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(arr[1]);
            return;
        }

        int[][] DP = new int[N + 1][3];
        DP[1][1] = arr[1];
        DP[1][2] = arr[1];

        DP[2][1] = arr[2];
        DP[2][2] = arr[1]+arr[2];


        for (int i = 3; i <= N; i++) {
            DP[i][1] = Math.max(DP[i - 2][1], DP[i - 2][2]) + arr[i];
            DP[i][2] = DP[i - 1][1] + arr[i];
        }
        System.out.println(Math.max(DP[N][1], DP[N][2]));
    }
}
