import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13702 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 1;
        long end = max;
        long answer=0;
        while (start <= end) {
            long mid = (start + end) / 2;

            long remain = getRemain(mid);
            if (remain < K) {
                end = mid - 1;
            } else if (remain >= K) {
                answer = mid;
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static long getRemain(long value) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / value;
        }
        return sum;
    }
}
