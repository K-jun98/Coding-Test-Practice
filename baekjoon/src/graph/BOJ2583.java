package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2583 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M, N, K;
    static boolean[][] arr;
    static int count = 0;

    static int[] yArr = new int[]{1, 0, -1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            fillBox(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!arr[i][j]) {
                    dfs(i, j);
                    queue.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(queue.size());

        queue.stream().forEach(x -> System.out.printf(x + " "));

    }

    public static void fillBox(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                arr[i][j] = true;
            }
        }
    }

    public static void dfs(int y, int x) {
        arr[y][x] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int dy = y + yArr[i];
            int dx = x + xArr[i];
            if (dy >= 0 && dy < arr.length && dx >= 0 && dx < arr[0].length && !arr[dy][dx]) {
                dfs(dy, dx);
            }
        }

    }

}
