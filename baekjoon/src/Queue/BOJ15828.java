package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int value = Integer.parseInt(br.readLine());

        while (value != -1) {
            if (value == 0) {
                queue.poll();
            } else if (queue.size() < N) {
                queue.add(value);
            }
            value = Integer.parseInt(br.readLine());
        }

        String collect = queue.stream().map(String::valueOf).collect(Collectors.joining(" "));
        collect = collect.isEmpty() ? "empty" : collect;
        System.out.println(collect);
    }
}
