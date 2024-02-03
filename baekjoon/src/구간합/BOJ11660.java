package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr.length; j++) {
                Integer value = Integer.valueOf(st.nextToken());
                arr[i][j] += arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + value;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int sum = arr[y2][x2] - arr[y1 - 1][x2] - arr[y2][x1 - 1] + arr[y1 - 1][x1 - 1];
            System.out.println(sum);
        }
    }
}
