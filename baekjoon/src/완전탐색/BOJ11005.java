package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String[] str = new String[36];
        str[0] = "0";
        str[1] = "1";
        str[2] = "2";
        str[3] = "3";
        str[4] = "4";
        str[5] = "5";
        str[6] = "6";
        str[7] = "7";
        str[8] = "8";
        str[9] = "9";
        for (int i = 10; i < 36; i++) {
            char i1 = (char) ((char) 55 + i);
            str[i] = String.valueOf(i1);
        }

        StringBuilder sb = new StringBuilder();
        while (N >= B) {
            sb.append(str[N % B]);
            N /= B;
        }
        sb.append(str[N]);
        sb.reverse();
        System.out.println(sb);
    }
}
