package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1987 {

    static int R, C;
    static int[] yArr = new int[]{1, 0, -1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};
    static boolean[] arr = new boolean[26];
    static char[][] chars;
    static int[][] ints;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        System.out.println('0'-0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[R][C];
        char c = chars[0][0];
        arr[c - 65] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int y = temp[0];
            int x = temp[1];

            for (int i = 0; i < 4; i++) {
                int dy = y + yArr[i];
                int dx = x + xArr[i];
                if (dy >= 0 && dy < chars.length && dx >= 0 && dx < chars[0].length && !arr[chars[dy][dx] - 65]) {
                    queue.add(new int[]{dy, dx});
                    arr[chars[dy][dx] - 65] = true;
                    ints[dy][dx] = ints[y][x] + 1;
                }
            }
        }
    }

}
