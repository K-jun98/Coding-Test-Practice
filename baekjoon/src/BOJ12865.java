import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weight = new int[N + 1]; // i번째 물건의 무게
        int[] value = new int[N + 1]; // i번째 물건의 가치

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100_001];
        for (int i = 1; i < weight.length; i++) {
            int w = weight[i];
            for (int j = 100_000; j >= w; j--) {
                dp[j] = Math.max(dp[j], value[i] + dp[j - w]);
            }
        }
        System.out.println(dp[K]);
    }
}
