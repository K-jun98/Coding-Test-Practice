package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0, right = N - 1;

        int min = Integer.MAX_VALUE;
        int leftValue = 0;
        int rightValue = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(min) > Math.abs(sum)) {
                min = sum;
                leftValue = arr[left];
                rightValue = arr[right];
            }
            if (sum == 0)
                break;
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            }
        }

        System.out.println(leftValue + " " + rightValue);
    }

}
