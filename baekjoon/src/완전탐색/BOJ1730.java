package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1730 {

    static int[] yArr = new int[]{-1, 0, 1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};
    static int y = 0;
    static int x = 0;
    static char[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], '.');
        }
        char[] charArray = br.readLine().toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            change(charArray[i]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(String.valueOf(arr[i][j]));
            }
            System.out.println();
        }
    }

    public static void change(char dir) {
        int dy = 0;
        int dx = 0;
        if (dir == 'U') {
            dy = y + yArr[0];
            dx = x + xArr[0];
        } else if (dir == 'L') {
            dy = y + yArr[1];
            dx = x + xArr[1];
        } else if (dir == 'D') {
            dy = y + yArr[2];
            dx = x + xArr[2];
        } else if (dir == 'R') {
            dy = y + yArr[3];
            dx = x + xArr[3];
        }
        if (dy >= 0 && dy < N && dx >= 0 && dx < N) {
            change2(y, x, dir);
            change2(dy, dx, dir);
            y = dy;
            x = dx;
        }
    }

    public static void change2(int y, int x, char c) {
        if (c == 'U' || c == 'D') {
            if (arr[y][x] == '-') {
                arr[y][x] = '+';
            } else if (arr[y][x] == '.') {
                arr[y][x] = '|';
            }
        } else if (c == 'L' || c == 'R') {
            if (arr[y][x] == '|') {
                arr[y][x] = '+';
            } else if (arr[y][x] == '.') {
                arr[y][x] = '-';
            }
        }
    }
}
