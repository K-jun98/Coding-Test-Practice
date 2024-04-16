import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ25709 {

    static int answer =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            N = replace(String.valueOf(N));
            if (N != 0) {
                N--;
                answer++;
            }
        }

        System.out.println(answer);
    }


    public static int replace(String value) {
        int i1 = value.length();
        String replace = value.replace("1", "");
        int i2 = replace.length();
        answer += i1 - i2;

        if (replace.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(replace);
    }
}
