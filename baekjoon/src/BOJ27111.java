import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[200_001];

        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            boolean b = Integer.parseInt(st.nextToken()) == 0 ? false : true;

            if (arr[a] == b) {
                answer++;
            } else if (arr[a] != b) {
                arr[a] = b;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] ? 1 : 0;
        }

        System.out.println(answer);

    }
}
