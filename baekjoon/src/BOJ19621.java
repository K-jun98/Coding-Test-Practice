import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ19621 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int[] dp = new int[N];
        dp[0] = arr[0][2];

        for (int i = 1; i < N; i++) {
            dp[i] = arr[i][2];
            for (int j = 0; j < i; j++) {
                if (arr[j][1] <= arr[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][2]);
                }

            }
        }

        int maxPeople = 0;
        for (int people : dp) {
            maxPeople = Math.max(maxPeople, people);
        }

        System.out.println(maxPeople);
    }
}
