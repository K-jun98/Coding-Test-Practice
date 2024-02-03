package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] time = new int[100_001], total = new int[100_001];
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        queue.add(N);
        total[N] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            int[] ints = new int[]{poll - 1, poll + 1, poll * 2};

            for (int v : ints) {
                if (v >= 0 && v < 100_001) {
                    if (time[v] == 0) {
                        queue.add(v);
                        time[v] = time[poll] + 1;
                        total[v] = total[poll];
                    } else if (time[v] == time[poll] + 1) {
                        total[v] += total[poll];
                    }
                }
            }
        }
        System.out.println(time[K]);
        System.out.println(total[K]);
    }


}
