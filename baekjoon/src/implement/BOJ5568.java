package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BOJ5568 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] arrB;
    static List<String> list = new ArrayList<>();
    static int K;
    static StringBuilder sb;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        arrB = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        count();
        System.out.println(set.size());
    }

    public static void count() {
        if (list.size() == K) {
            sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            set.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!arrB[i]) {
                list.add(String.valueOf(arr[i]));
                arrB[i] = true;
                count();
                arrB[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
