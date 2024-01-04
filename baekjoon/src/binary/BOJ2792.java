package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2792 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
            max = Math.max(value, max);
        }

        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    count++;
                }
            }

            if (count > N) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }

        }
            System.out.println(answer);
    }

}
