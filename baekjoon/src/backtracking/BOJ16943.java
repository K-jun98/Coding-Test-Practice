package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16943 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A;
    static int B;
    static int C;
    static int[] arr;
    static boolean[] arrB;
    static List<Integer> list = new ArrayList<>();
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String aValue = st.nextToken();
        A = Integer.parseInt(aValue);
        B = Integer.parseInt(st.nextToken());
        arr = new int[aValue.length()];
        arrB = new boolean[aValue.length()];
        for (int i = 0; i < aValue.length(); i++) {
            arr[i] = aValue.charAt(i) - 48;
        }
        find();
        System.out.println(answer);
    }

    public static void find() {
        if (list.size() == arr.length) {
            if (list.get(0) != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                }
                int value = Integer.parseInt(sb.toString());
                if (value < B) {
                    answer = Math.max(value, answer);
                }
                return;
            } else {
                return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arrB[i] ==false) {
                list.add(arr[i]);
                arrB[i] = true;
                find();
                arrB[i] = false;
                list.remove(list.size() - 1);
            }
        }

    }
}
