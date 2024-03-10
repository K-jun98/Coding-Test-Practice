import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25427 {
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        S = br.readLine();

        S = S.replaceAll("[^DKSH]", "");

        long[] dp = new long[5];

        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            switch (c) {
                case 'H':
                    dp[1]++;
                    break;
                case 'S':
                    dp[2] += dp[1];
                    break;
                case 'K':
                    dp[3] += dp[2];
                    break;
                case 'D':
                    dp[4] += dp[3];
                    break;
            }
        }
        System.out.println(dp[4]);
    }
}
