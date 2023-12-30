package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer> q;
    static Queue<Integer> pq;

    public static void main(String[] args) throws IOException {

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int find = Integer.parseInt(st.nextToken());
            q = new ArrayDeque<>();
            pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                q.add(value);
                pq.add(value);
            }
            System.out.println(find(find));
        }
    }

    private static int find(int find) {
        int answer = 0;
        while (true) {
            Integer poll = q.poll();
            if (poll == pq.peek()) {
                answer++;
                pq.remove();
                if (find == 0) {
                    return answer;
                }
                find--;
                continue;
            }
            if (poll != pq.peek()) {
                find += find == 0 ? q.size() : -1;
                q.add(poll);
            }
        }
    }
}
