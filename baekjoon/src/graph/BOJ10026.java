package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] arr;
    static char[][] arr2;

    static int[] yArr = new int[]{1, 0, -1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};
    static int answer;
    static int answer1;

    public static void main(String[] args) throws IOException {
        int length = Integer.parseInt(br.readLine());

        arr = new char[length][length];
        arr2 = new char[length][length];
        for (int i = 0; i < arr.length; i++) {
            String value = br.readLine();
            String replaced = value.replace("R", "G");
            arr[i] = value.toCharArray();
            arr2[i] = replaced.toCharArray();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                char c = arr[i][j];
                char c1 = arr2[i][j];
                if (c == 'R' || c == 'B' || c == 'G') {
                    dfs(i, j, arr);
                    answer++;
                }
                if (c1 == 'G' || c1 == 'B') {
                    dfs(i, j, arr2);
                    answer1++;
                }
            }
        }

        System.out.println(answer + " " + answer1);
    }

    public static void dfs(int y, int x, char[][] arr) {
        char c = arr[y][x];
        arr[y][x] = 'A';
        for (int i = 0; i < 4; i++) {
            int dy = y + yArr[i];
            int dx = x + xArr[i];
            if (dy >= 0 && dy < arr.length && dx >= 0 && dx < arr[0].length && arr[dy][dx] == c) {
                dfs(dy, dx, arr);
            }
        }
    }

}
