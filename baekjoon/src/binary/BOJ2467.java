package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2467 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::valueOf).toArray();

        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        int leftAnswer = 0;
        int rightAnswer = 0;

        while (leftIdx != rightIdx) {
            int sum = arr[leftIdx] + arr[rightIdx];

            if (sum < 0) {
                if (Math.abs(answer) >= Math.abs(sum)) {
                    answer = sum;
                    leftAnswer = leftIdx;
                    rightAnswer = rightIdx;
                }
                leftIdx++;
            } else if (sum > 0) {
                if (Math.abs(answer) >= Math.abs(sum)) {
                    answer = sum;
                    leftAnswer = leftIdx;
                    rightAnswer = rightIdx;
                }
                rightIdx--;
            } else {
                System.out.println(arr[leftIdx] + " " + arr[rightIdx]);
                return;
            }
        }
        System.out.println(arr[leftAnswer] + " " + arr[rightAnswer]);
    }
}
