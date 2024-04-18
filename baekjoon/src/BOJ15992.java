import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15992 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[1001][1001]; // dp[i][j]: j만큼의 수를 사용해 i를 만드는 경우의 수
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for (int i = 4; i < 1001; i++) {
            dp[i][i] = 1;
            for (int j = 2; j < i; j++) {
                dp[i][j] = (int) ((1L * dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % 1_000_000_009);
            }
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] % 1_000_000_009);
        }
    }
}
