package unknown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511 {
    static int N, K, answer = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        dfs(0, 0); // 초기 상태로 시작
        System.out.println(answer);
    }

    private static void dfs(int num, int length) {
        if (length > 0) {
            if (num <= N) {
                answer = Math.max(answer, num); // 가능한 최대값 갱신
            } else {
                return; // N을 초과하면 탐색 중지
            }
        }

        if (length == String.valueOf(N).length()) {
            return; // 최대 길이 도달 시 탐색 중지
        }

        for (int i = 0; i < K; i++) {
            dfs(num * 10 + arr[i], length + 1); // 다음 숫자 추가하여 탐색
        }
    }
}

