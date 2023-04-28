import java.util.Scanner;

public class BOJ14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[Integer.parseInt(sc.nextLine())][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[] dp = new int[arr.length + 1];

        for (int i = arr.length-1; i >= 0; i--) {
            if (i + arr[i][0] <= arr.length) {
                dp[i] = Math.max(dp[i + 1], arr[i][1] + dp[i + arr[i][0]]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[0]);
    }
}
