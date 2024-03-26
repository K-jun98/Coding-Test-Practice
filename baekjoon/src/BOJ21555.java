import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21555 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] Aarr = new long[N + 1];
        long[] Barr = new long[N + 1];
        // A 비용 입력
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            Aarr[j] = Integer.parseInt(st.nextToken());
        }
        // B비용 입력
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            Barr[j] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N + 1][2];
        dp[1][0] = Aarr[1];
        dp[1][1] = Barr[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min((dp[i - 1][0] + Aarr[i]), dp[i - 1][1] + K + Aarr[i]);
            dp[i][1] = Math.min((dp[i - 1][1] + Barr[i]), dp[i - 1][0] + K + Barr[i]);
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
