import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단원의 수
        int T = Integer.parseInt(st.nextToken()); // 사용 가능한 총 시간

        int[] time = new int[N + 1];
        int[] point = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            point[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10_001]; // dp[i] = i시간 동안 공부해 받을 수 있는 최대 점수
        // dp[i] = max(dp[i], dp[i-time[j]]+point[j]

        for (int i = 1; i <= N; i++) {
            int t = time[i];
            for (int j = 10000; j >= t; j--) {
                dp[j] = Math.max(dp[j], dp[j - t] + point[i]);
            }
        }

        System.out.println(dp[T]);
    }
}
