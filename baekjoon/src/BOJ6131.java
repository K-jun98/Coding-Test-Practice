import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6131 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int A = 2;
        int B = 1;

        int answer = 0;

        while (A <= 500) {
            int aa = (int)Math.pow(A, 2);
            int bb = (int)Math.pow(B, 2);

            if (bb + N == aa) {
                answer++;
                A++;
            } else if (bb+ N < aa) {
                B++;
            } else if (bb + N > aa) {
                A++;
            }
        }
        System.out.println(answer);
    }
}
