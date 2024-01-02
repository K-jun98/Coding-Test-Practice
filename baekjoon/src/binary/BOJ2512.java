package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] nArr;
    static int M;
    static int max;
    static int answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
            max = max > nArr[i] ? max : nArr[i];
        }
        M = Integer.parseInt(br.readLine());
        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < nArr.length; i++) {
                sum += nArr[i] > mid ? mid : nArr[i];
            }
            if (sum < M) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }

}
