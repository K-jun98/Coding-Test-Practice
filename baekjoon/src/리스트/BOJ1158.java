package 리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int count = 1;
        while (!list.isEmpty()) {
            if (count == K) {
                list2.add(list.remove(0));
                count = 1;
            } else if (count != K) {
                list.add(list.remove(0));
                count++;
            }
        }

        String collect = list2.stream().map(String::valueOf).collect(Collectors.joining(", "));

        System.out.println("<"+collect+">");
    }
}
