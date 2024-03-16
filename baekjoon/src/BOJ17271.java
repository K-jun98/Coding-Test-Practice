import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17271 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] dp = new long[10_001];

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (i >= M) {
                dp[i] += dp[i - M];
            }
            dp[i] %= 1000000007;
        }

        System.out.println(dp[N]);
    }
}
