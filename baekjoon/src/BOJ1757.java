import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[][][] dp = new int[N + 1][M + 1][2]; //dp[i][j][0] -> 내려가는 dp[i][j][1] -> 올라가는

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0][0] = Math.max(Math.max(dp[i - 1][1][1], dp[i - 1][1][0]), dp[i - 1][0][0]);
            dp[i][0][1] = dp[i][0][0];
            for (int j = 1; j <= Math.min(i, M); j++) {
                dp[i][j][1] = dp[i - 1][j - 1][1] + arr[i];
                if (j == M) {
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
            }
        }

        System.out.println(dp[N][0][0]);
    }
}
