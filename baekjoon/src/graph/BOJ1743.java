package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1743 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] arr;
    static int[] yArr = new int[]{1, 0, -1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};
    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new char[y][x];

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = '#';
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '#') {
                    count = 1;
                    dfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);

    }

    private static void dfs(int y, int x) {
        arr[y][x] = '.';

        for (int i = 0; i < 4; i++) {
            int dy = y + yArr[i];
            int dx = x + xArr[i];

            if (dy >= 0 && dy < arr.length && dx >= 0 && dx < arr[0].length && arr[dy][dx] == '#') {
                count++;
                dfs(dy, dx);
            }
        }
    }

}
