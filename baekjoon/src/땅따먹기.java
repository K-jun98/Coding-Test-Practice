public class 땅따먹기 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];

        for(int i =1; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                int max = 0;
                for(int k=0; k<dp[i].length; k++){
                    if(k!=j){
                        max = Math.max(max,dp[i-1][k]);
                    }
                }
                dp[i][j] = max+land[i][j];
            }
        }

        int answer = 0;

        for(int i =0; i<4; i++){
            answer = Math.max(dp[dp.length-1][i],answer);
        }

        return answer;
    }

}
