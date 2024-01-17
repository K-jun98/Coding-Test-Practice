package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2606 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] arr;
    static boolean[] check;

    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            arr[left][right] = true;
            arr[right][left] = true;
        }

        check[1] = true;
        dfs(1);

        System.out.println(answer-1);
    }

    public static void dfs(int idx) {
        check[idx] = true;
        answer++;
        for (int i = 1; i < arr.length; i++) {
            if (arr[idx][i] == true && check[i] == false) {
                dfs(i);
            }
        }
    }

}
