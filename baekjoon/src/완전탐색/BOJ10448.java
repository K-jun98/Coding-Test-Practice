package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ10448 {

    static int[] tArr;
    static boolean[] bArr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        bArr = new boolean[T];

        // 자연수 K의 입력
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 앞선 데이터 넣기
        tArr = new int[45];
        tArr[1] = 1;
        tArr[2] = 3;
        tArr[3] = 6;

        // 최대범위 1000까지 공의 수 구하기
        for (int i = 4; i < 45; i++) {
            tArr[i] = tArr[i - 1] + i;
        }
        for (int i = 0; i < arr.length; i++) {
            dfs(i, 0, 0, arr[i]);
        }

        for (int i = 0; i < bArr.length; i++) {
            System.out.println(bArr[i] == true ? 1 : 0);
        }

    }

    public static void dfs(int idx, int count, int curV, int target) {
        if (curV > target) {
            return;
        }
        if (count == 3) {
            if (curV == target) {
                bArr[idx] = true;
                return;
            }
            return;
        }
        for (int i = 1; i <= 44; i++) {
            dfs(idx, count + 1, curV + tArr[i], target);
        }
    }
}
