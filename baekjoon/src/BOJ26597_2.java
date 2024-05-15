import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ26597_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Q = Integer.parseInt(br.readLine());

        long max = 1000000000000000000L; // 이것보단 작다
        long min = -1000000000000000000L; // 이것보단 크다
        long answer = Long.MAX_VALUE;

        for (int i = 1; i <= Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long value = Long.parseLong(st.nextToken());
            char c = st.nextToken().charAt(0);

            if (c == '^') {
                min = Math.max(value + 1, min);
            } else {
                max = Math.min(value - 1, max);
            }

            if (max < min) {
                System.out.println("Paradox!");
                System.out.println(i);
                return;
            } else if (max == min) {
                answer = Math.min(answer, i);
            }
        }

        if (answer == Long.MAX_VALUE) {
            System.out.println("Hmm...");
        } else {
            System.out.println("I got it!");
            System.out.println(answer);
        }
    }

}
