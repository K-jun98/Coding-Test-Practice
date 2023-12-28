package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ10597 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] bArr = new boolean[51];
    static List<Integer> list = new ArrayList<>();
    static int N = 0;

    public static void main(String[] args) throws IOException {

        String str = br.readLine();
        N = str.length();

        if (N > 9) N -= (N - 9) / 2;
        find(str);
    }

    public static void find(String str) {
        if (str.isEmpty()) {
            list.forEach(x -> System.out.printf(x + " "));
            System.exit(0);
        }

        for (int i = 1; i <= 2; i++) {
            String sub = str.substring(0, i);
            int value = Integer.valueOf(sub);
            if (value <=N && !bArr[value]) {
                list.add(value);
                bArr[value] = true;
                find(str.substring(i));
                list.remove(list.size() - 1);
                bArr[value] = false;
            }
            if (str.length() == 1) {
                break;
            }
        }
    }


}
