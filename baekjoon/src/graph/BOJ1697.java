package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, M;
    static int[] arr = new int[100_001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr[N] = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int[] ints = {poll + 1, poll - 1, poll * 2};

            for (int i = 0; i < ints.length; i++) {
                if (ints[i] >= 0 && ints[i] < 100001 && arr[ints[i]] == 0) {
                    arr[ints[i]] = arr[poll] + 1;
                    queue.add(ints[i]);
                }
            }
        }

        System.out.println(arr[K] -1);
    }

}
