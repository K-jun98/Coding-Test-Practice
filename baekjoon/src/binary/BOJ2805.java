package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int answer = 0;
        int left = 0, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;

            long max1 = getMax(arr, mid);
            if (max1 >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid- 1;
            }
        }

        System.out.println(answer);

    }

    public static long getMax(int[] arr, int top) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - top > 0 ? (long)arr[i] - top : 0;
        }
        return sum;
    }
}
