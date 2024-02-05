package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = arr[0], answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            while (right < N-1 && sum < S) {
                sum += arr[++right];
            }
            if (sum >= S) {
                answer = Math.min(right - left, answer);
            }
            sum -= arr[left];
            left++;
        }
        answer = answer == Integer.MAX_VALUE ? 0 : answer + 1;
        System.out.println(answer);

    }
}
