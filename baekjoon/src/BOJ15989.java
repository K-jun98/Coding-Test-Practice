import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[10_001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i][1] = 1;
            dp[i][2] = dp[i-2][1]+dp[i-2][2];
            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]);
        }
    }
}
