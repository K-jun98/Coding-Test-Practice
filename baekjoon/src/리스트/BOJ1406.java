package 리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        List<String> collect = Arrays.stream(br.readLine().split("")).collect(Collectors.toCollection(LinkedList::new));
        int count = Integer.parseInt(br.readLine());

        int corsor = collect.size();
        while (count-- > 0) {
            String[] split = br.readLine().split(" ");

            String s = split[0];
            if (s.equals("L")) {
                corsor = Math.max(0, corsor - 1);
            } else if (s.equals("D")) {
                corsor = Math.min(collect.size(), corsor + 1);
            } else if (s.equals("B") && corsor != 0) {
                collect.remove(--corsor);
            } else if (s.equals("P")) {
                String s1 = split[1];
                collect.add(corsor++, s1);
            }
        }

        String collect1 = collect.stream().collect(Collectors.joining());
        System.out.println(collect1);
    }
}
