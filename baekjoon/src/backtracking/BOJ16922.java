package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16922 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr = new int[]{1, 5, 10, 50};

    static boolean[] bArr = new boolean[10000];
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        find(0, 0, 0);
        System.out.println(M);
    }

    public static void find(int idx, int count, int point) {
        if (count == N) {
            if (!bArr[point]) {
                bArr[point] = true;
                M++;
            }
            return;
        }

        for (int i = idx; i < 4; i++) {

            find(i, count + 1, point + arr[i]);
        }
    }

}
