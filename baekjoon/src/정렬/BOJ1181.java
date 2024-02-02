package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> list = new LinkedHashSet<>();

        for (int i1 = 0; i1 < N; i1++) {
            list.add(br.readLine());
        }
        List<String> list1 = list.stream().collect(Collectors.toList());

        Collections.sort(list1, (o1,o2)->{
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            return o1.length()-o2.length();
        });
        list1.forEach(System.out::println);
    }

}
