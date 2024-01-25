package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph.get(left).add(right);
            graph.get(right).add(left);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int[] par = new int[N + 1];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Integer value : graph.get(poll)) {
                if (par[value] == 0) {
                    queue.add(value);
                    par[value] = poll;
                }
            }
        }

        for (int i = 2; i < par.length; i++) {
            System.out.println(par[i]);
        }
    }

}
