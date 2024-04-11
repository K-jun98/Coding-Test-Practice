import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOJ5567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[n + 1];
        List<ArrayList<Integer>> collect = IntStream.rangeClosed(0, n).mapToObj(x -> new ArrayList<Integer>()).collect(Collectors.toList());

        for (int i = 0; i <m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            collect.get(i1).add(i2);
            collect.get(i2).add(i1);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < collect.get(1).size(); i++) {
            check[collect.get(1).get(i)] =true;
            queue.add(collect.get(1).get(i));
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int j = 0; j < collect.get(poll).size(); j++) {
                check[collect.get(poll).get(j)] = true;
            }
        }

        int answer = 0;
        for (int i = 2; i <check.length; i++) {
            if(check[i]){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
