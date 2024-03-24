import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ16712 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>(); // 모든 인원의 점수
        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N - M + 1; i++) {
            queue.add(Integer.valueOf(st.nextToken()));
        }

        List<Integer> list2 = new ArrayList<>(); // 경쟁중인 인원들 리스트
        for (int i = 0; i < M; i++) {
            list2.add(list.remove(0));
        }

        while (!queue.isEmpty()) {
            Collections.sort(list2);
            list2.remove(queue.poll()-1);
            if (list.size() > 0) {
                list2.add(list.remove(0));
            }
        }

        System.out.println(list2.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }

}
