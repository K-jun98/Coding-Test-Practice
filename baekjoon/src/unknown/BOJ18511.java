package unknown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ18511 {
    static int N,K,answer;
    static int[] arr;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        size = s.length();
        N = Integer.parseInt(s);
        K = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        ArrayList<Integer> list = new ArrayList<>();
        dfs(list);
        System.out.println(answer);
    }

    private static void dfs(List<Integer> list) {
        if (list.size() >= size-1) {
            String collect = list.stream().map(String::valueOf).collect(Collectors.joining());
            int i = Integer.parseInt(collect);
            if (i <= N) {
                answer = Math.max(answer, i);
            }
            if (list.size() == size) {
            return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            dfs(list);
            list.remove(list.size() - 1);
        }
    }

}
