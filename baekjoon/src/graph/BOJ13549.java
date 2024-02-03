package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ13549 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] time = new int[100_001];


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        time[N] = 1;


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if (poll == K) {
                break;
            }

            int[] ints = {poll * 2, poll + 1, poll - 1};
            for (int i = 0; i < 3; i++) {
                int anInt = ints[i];
                if (anInt >= 0 && anInt < 100_001) {
                    if (time[ints[i]] == 0) {
                        if (i == 0) {
                            queue.addFirst(ints[i]);
                            time[ints[i]] = time[poll];
                        } else {
                            queue.addLast(ints[i]);
                            time[ints[i]] = time[poll] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(time[K] - 1);
    }

}
