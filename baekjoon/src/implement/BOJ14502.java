package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14502 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr, temp;

    static int[] yArr = new int[]{-1, 0, 1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};

    static int answer = Integer.MIN_VALUE;
    static int count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        setWall(0);
        System.out.println(answer);
    }

    public static void setWall(int depth) {
        if (depth == 3) {
            copy();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (temp[i][j] == 2)
                        spread(i, j);
                }
            }
            count();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    setWall(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    public static void spread(int y, int x) {
        for (int k = 0; k < 4; k++) {
            int dy = y + yArr[k];
            int dx = x + xArr[k];
            if (dy >= 0 && dy < temp.length && dx >= 0 && dx < temp[0].length && temp[dy][dx] == 0) {
                temp[dy][dx] = 2;
                spread(dy, dx);
            }
        }
    }

    private static void copy() {
        temp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
    }

    private static void count() {
        count = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (temp[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(count, answer);
    }
}


