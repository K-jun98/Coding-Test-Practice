package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20444 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        long left = 0, right = n;
        while (left <= right) {
            long row = (right + left) / 2;
            long col = n - row;
            long value = isPossible(row, col);

            if (value == k) {
                System.out.println("YES");
                return;
            } else if (value > k) {
                right = row - 1;
            } else if (value < k) {
                left = row + 1;
            }
        }
        System.out.println("NO");
    }

    private static long isPossible(long row, long col) {
        return (row + 1) * (col + 1);
    }

}
