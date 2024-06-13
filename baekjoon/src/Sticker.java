import java.util.Scanner;

public class Sticker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = sc.nextInt();
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }

        sc.close();
    }
}
