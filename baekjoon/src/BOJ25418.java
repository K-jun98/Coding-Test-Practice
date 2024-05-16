import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ25418 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1_000_001];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(A);
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[A] = 0;

        while (!queue.isEmpty()) {
            int value = queue.poll();

            if (value * 2 <= 1_000_000 && arr[value * 2] == Integer.MAX_VALUE) {
                queue.add(value * 2);
                arr[value * 2] = arr[value] + 1;
            }
            if (value + 1 <= 1_000_000 && arr[value + 1] == Integer.MAX_VALUE) {
                queue.add(value + 1);
                arr[value + 1] = arr[value] + 1;
            }
        }

        System.out.println(arr[K]);
    }
}
