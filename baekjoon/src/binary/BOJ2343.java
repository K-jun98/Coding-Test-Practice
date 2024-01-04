package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2343 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int min = 0, max = 0;
        for (int i = 0; i < N; i++) {
            Integer value = Integer.valueOf(st.nextToken());
            list.add(value);
            max += value;
            min = Math.max(min, value);
        }

        while (min <= max) {
            int mid = (min + max) / 2;
            if (isPossible(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean isPossible(int mid) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer value = list.get(i);
            sum += value;
            if (sum > mid) {
                count++;
                i--;
                sum = 0;
            }
        }
        return count + 1 <= M;
    }
}
