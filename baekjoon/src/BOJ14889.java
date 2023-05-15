import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    private static int N;
    private static int MIN = Integer.MAX_VALUE;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer tokens;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            tokens = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        makeCombination(N / 2, 1, new boolean[N + 1]);
        System.out.println(MIN);
    }

    private static void makeCombination(int toChoose, int startIdx, boolean[] visited) {
        if (toChoose == 0) {

            int sum = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (visited[i] == visited[j]) {
                        if (visited[i]) {
                            sum += arr[i][j];
                        } else {
                            sum -= arr[i][j];
                        }
                    }
                }
            }
            MIN = Math.min(MIN, Math.abs(sum));
            return;
        }

        for (int i = startIdx; i <= N; i++) {
            visited[i] = true;
            makeCombination(toChoose - 1, i + 1, visited);
            visited[i] = false;
        }
    }
}
