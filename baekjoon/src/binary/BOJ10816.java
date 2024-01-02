package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BOJ10816 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Map<Integer, Long> frequencyMap = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(groupingBy(i -> i, counting()));

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(st.nextToken());
            Long finedValue = frequencyMap.get(value);
            finedValue = finedValue == null ? 0 : finedValue;
            sb.append(finedValue).append(" ");
        }
        System.out.println(sb);
    }
}
