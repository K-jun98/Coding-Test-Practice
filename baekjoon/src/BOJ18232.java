import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18232 {

    static int N, M, S, E;
    static List<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + 1; // 정거장 수
        M = Integer.parseInt(st.nextToken()); // 텔레포트 수

        arr = new ArrayList[N];
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 현재 위치
        E = Integer.parseInt(st.nextToken()); // 목적지

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            arr[p1].add(p2);
            arr[p2].add(p1);
        }

        int[] count = new int[N];
        Arrays.fill(count, Integer.MAX_VALUE);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(S);
        count[S] = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            // 텔레포트
            if (poll > 0 && poll < count.length) {
                for (int i = 0; i < arr[poll].size(); i++) {
                    Integer i1 = arr[poll].get(i);
                    if (i1 > 0 && i1 < count.length && count[i1] == Integer.MAX_VALUE) {
                        queue.add(i1);
                        count[i1] =  count[poll] + 1;
                    }
                }
            }

            // -1 이동
            if (poll - 1 > 0 && count[poll - 1] == Integer.MAX_VALUE) {
                queue.add(poll - 1);
                count[poll - 1] =  count[poll] + 1;
            }
            // +1 이동
            if (poll + 1 < count.length && count[poll + 1] == Integer.MAX_VALUE) {
                queue.add(poll + 1);
                count[poll + 1] =  count[poll] + 1;
            }

        }
        System.out.println(count[E]);

    }
}
