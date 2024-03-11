import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16396 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (x1, x2) -> {
            if (x1[0] == x2[0]) {
                return x1[1] - x2[1];
            }
            return x1[0] - x2[0];
        });
        int start = 0;
        int end = 0;
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int[] ints = arr[i];
            int tempStart = ints[0];
            int tempEnd = ints[1];

            if (end >= tempStart) {
                end = Math.max(tempEnd, end);
            } else if (end < tempStart) {
                answer += (end - start);
                start = tempStart;
                end = tempEnd;
            }
        }
        answer += (end - start);
        System.out.println(answer);
    }
}
