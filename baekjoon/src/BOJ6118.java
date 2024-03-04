import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ6118 {

    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        check = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            list.get(i1).add(i2);
            list.get(i2).add(i1);
        }


        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> set = new PriorityQueue<>();
        queue.add(1);
        check[1] = 1;
        int max = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int i = 0; i < list.get(poll).size(); i++) {
                Integer i1 = list.get(poll).get(i);
                if (check[i1] == 0) {
                    check[i1] = check[poll] + 1;
                    queue.add(i1);
                    if (check[i1] > max) {
                        max = check[i1];
                        set = new PriorityQueue<>();
                        set.add(i1);
                    } else if (check[i1] == max) {
                        set.add(i1);
                    }
                }
            }
        }
        max--;
        System.out.println(set.peek() + " " + max + " " + set.size());
    }
}
