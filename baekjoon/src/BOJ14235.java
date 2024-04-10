import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;

        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                System.out.println(queue.isEmpty() ? -1 : queue.poll());
            } else {
                for (int i = 0; i < a; i++) {
                    queue.add(Integer.valueOf(st.nextToken()));
                }
            }
        }
    }
}
