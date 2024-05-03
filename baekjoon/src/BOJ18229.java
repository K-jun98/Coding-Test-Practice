import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] reach = new int[N]; // 각 사람이 손을 뻗은 총 길이를 저장할 배열

        for (int j = 0; j < M; j++) { // 각 단계별로 사람들이 손을 뻗음
            for (int i = 0; i < N; i++) { // N명의 사람들 각각에 대하여
                reach[i] += arr[i][j]; // i번 사람이 j번째에 손을 뻗은 길이를 더함
                if (reach[i] >= K) { // i번 사람이 K 이상 손을 뻗었다면
                    System.out.println((i + 1) + " " + (j + 1)); // 해당 사람과 손을 뻗은 횟수 출력
                    return; // 프로그램 종료
                }
            }
        }
    }
}
