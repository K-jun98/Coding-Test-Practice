import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5911 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 0;

        Queue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr1[3] - arr2[3]);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            queue.add(new int[]{p, s, p + s, (p / 2) + s});
        }

        boolean coupon = false;
        while (B >= 0 && !queue.isEmpty()) {
            int[] poll = queue.poll();
            int total = poll[2];
            int halfTotal = poll[3];
//              System.out.println("B+p+s = " + halfTotal + " " + B);
            if (B >= total) {
                B -= total;
                answer++;
                continue;
            }
            if (!coupon && B >= halfTotal) {
                B -= halfTotal;
                coupon = true;
                answer++;
                continue;
            }
            break;
        }
        System.out.println(answer);
    }
}
