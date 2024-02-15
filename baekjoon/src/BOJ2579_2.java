import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        if (N == 1) {
            System.out.println(arr[1]);
            return;
        }

        int[] dp = new int[N + 1];
        dp[1] = arr[1];
        dp[2] = arr[2];
        dp[3] = arr[3];

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1], dp[i - 2]),dp[i-3]) + arr[i];
        }
        System.out.println(sum - dp[N] + arr[N]);
    }
}

