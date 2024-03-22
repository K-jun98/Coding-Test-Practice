import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16195 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[1001][1001]; // dp[i][j]: j만큼의 수를 사용해 i를 만드는 경우의 수
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for (int i = 4; i < 1001; i++) {
            dp[i][i] = 1;
            for (int j = 2; j < i; j++) {
                dp[i][j] = ((1L * dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % 1_000_000_009);
            }
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            for (int k = 0; k <= j; k++) {
                sum = (sum+dp[i][k]) % 1_000_000_009;
            }

            System.out.println(sum);
        }
    }
}
