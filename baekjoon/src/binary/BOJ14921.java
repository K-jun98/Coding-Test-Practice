package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14921 {

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

        while (leftIdx != rightIdx) {
            int sum = arr[leftIdx] + arr[rightIdx];
            if (sum < 0) {
                leftIdx++;
                answer = Math.abs(sum) < Math.abs(answer) ? sum : answer;
            } else if (sum > 0) {
                rightIdx--;
                answer = Math.abs(sum) < Math.abs(answer) ? sum : answer;
            } else {
                System.out.println("0");
                return;
            }
        }
        System.out.println(answer);
    }

}
