import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1890 {

    static int[][] dp = new int[1][1];
    static int[][] arr = new int[1][1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        arr = new int[c][c];
        dp = new int[c][c];
        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findCheck(0,0);
        System.out.println(dp[c-1][c-1]);
    }

    public static void findCheck(int y, int x) {
        if (y < dp.length && x < dp[0].length) {
            int i = arr[y][x];
            dp[y][x]++;
            if(i ==0){
                return;
            }
            findCheck(y + i, x);
            findCheck(y, x + i);
        }
    }

}
