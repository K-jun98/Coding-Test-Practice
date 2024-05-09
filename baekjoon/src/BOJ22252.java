import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.util.Collections.reverseOrder;

public class BOJ22252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        StringTokenizer st;
        //고릴라 이름, 점수 정렬된 큐
        Map<String, Queue<Integer>> map = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();

            // 점수 저장할 때
            if (value.equals("1")) {
                String name = st.nextToken();
                Queue<Integer> queue = map.getOrDefault(name, new PriorityQueue<>(reverseOrder()));

                int C = Integer.parseInt(st.nextToken());
                while (C-- > 0) {
                    queue.add(Integer.valueOf(st.nextToken()));
                }
                map.put(name, queue);
            } else if (value.equals("2")) { // 점수 더하기
                String name = st.nextToken();
                Queue<Integer> queue = map.get(name);
                if (queue == null) continue;
                int C = Integer.parseInt(st.nextToken());
                while (C-- > 0 && !queue.isEmpty()) {
                    answer += queue.poll();
                }
            }
        }

        System.out.println(answer);
    }
}
