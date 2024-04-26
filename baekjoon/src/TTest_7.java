
class TTest_7 {

    public int solution(int[] array) {
        int[][] dp = new int[array.length + 1][2]; //dp[i][0] 은 본인 선택, dp[i][1]은 본인 선택 X
        for (int i = 0; i < array.length; i++) {
            dp[i + 1][0] = dp[i][1] + array[i];
            dp[i + 1][1] = Math.max(dp[i][0], dp[i][1]);
        }

        System.out.println(Math.max(dp[array.length][0], dp[array.length][1]));
        return 0;
    }


    public static void main(String[] args) {
        TTest_7 toss = new TTest_7();
        toss.solution(new int[]{30, 30, 60, 90, 60, 15, 15, 60});
        toss.solution(new int[]{45, 15, 30});
    }
}
