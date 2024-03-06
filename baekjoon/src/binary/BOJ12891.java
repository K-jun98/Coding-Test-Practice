package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ12891 {
    static Map<String, Integer> map;
    static String[] strs = new String[]{"A", "C", "G", "T"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String[] arr = new String[S];

        String str = br.readLine();
        for (int i = 0; i < S; i++) {
            arr[i] = String.valueOf(str.charAt(i));
        }

        // 포함 되어야 할 A, C, G, T 의 갯수
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int value = Integer.parseInt(st.nextToken());
            map.put(strs[i], value);
        }

        int left = 0, right = 0, answer = 0, length = 0;

        for (int i = 0; i <= S - P; i++) {
            while (length != P) {
                map.put(arr[right], map.get(arr[right]) - 1);
                length++;
                right++;
            }
            if (length == P) {
                answer += check() ? 1 : 0;
            }
            map.put(arr[left], map.get(arr[left]) + 1);
            length--;
            left++;
        }

        System.out.println(answer);
    }

    private static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (map.get(strs[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
