package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String replace = str.replace("()", "|");

        int count = 0;
        int answer = 0;
        for (int i = 0; i < replace.length(); i++) {
            char c = replace.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                answer++;
                count--;
            } else {
                answer += count;
            }
        }
        System.out.println(answer);
    }
}
