import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[K + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];
        dp[1] = arr[1];
        int answer = arr[1];

        for (int j = 2; j < arr.length; j++) {
            int mx = arr[j];
            for (int i = j - 1; i >= 1; i--) {
                if (arr[i] < arr[j]) {
                    mx = Math.max(mx, dp[i] + arr[j]);
                }
            }
            dp[j] = mx;
            answer = Math.max(answer, mx);
        }

        System.out.println(answer);
    }
}
