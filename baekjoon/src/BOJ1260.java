import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class BOJ1260 {
    static List<ArrayList<Integer>> collect;
    static boolean[] dfs = new boolean[1];
    static boolean[] bfs = new boolean[1];
    static List<Integer> dfsList = new ArrayList<>();
    static List<Integer> bfsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작

        collect = IntStream.rangeClosed(0, N).mapToObj(x -> new ArrayList<Integer>()).collect(Collectors.toList());
        dfs = new boolean[N + 1];
        bfs = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            collect.get(i1).add(i2);
            collect.get(i2).add(i1);
        }
        collect.forEach(x -> Collections.sort(x));

        dfs[V] = true;
        dfsList.add(V);
        dfs(V);
        bfs[V] = true;
        bfsList.add(V);
        bfs(V);
        System.out.println(dfsList.stream().map(v -> String.valueOf(v)).collect(joining(" ")));
        System.out.println(bfsList.stream().map(v -> String.valueOf(v)).collect(joining(" ")));

    }

    public static void dfs(int value) {

        ArrayList<Integer> list = collect.get(value);
        for (int i = 0; i < list.size(); i++) {
            Integer i1 = list.get(i);
            if (!dfs[i1]) {
                dfs[i1] = true;
                dfsList.add(i1);
                dfs(i1);
            }
        }
    }

    public static void bfs(int value) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(value);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ArrayList<Integer> integers = collect.get(poll);
            for (int i = 0; i < integers.size(); i++) {
                Integer i1 = integers.get(i);
                if (!bfs[i1]) {
                    queue.add(i1);
                    bfsList.add(i1);
                    bfs[i1] = true;
                }
            }
        }
    }
}
