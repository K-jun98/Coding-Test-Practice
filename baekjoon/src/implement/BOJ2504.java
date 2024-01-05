package implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class BOJ2504 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int bracket(String s) {
        Stack<Character> stack = new Stack<>();
        int[] p = new int[30];
        for(char c : s.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ']':
                    if(stack.empty()||stack.peek()!='[') {
                        return 0;
                    }
                    stack.pop();
                    p[stack.size()] += p[stack.size() + 1] == 0 ? 3 : p[stack.size() + 1] * 3;
                    p[stack.size() + 1] = 0;
                    break;
                case ')':
                    if(stack.empty()||stack.peek()!='(') {
                        return 0;
                    }
                    stack.pop();
                    p[stack.size()] += p[stack.size() + 1] == 0 ? 2 : p[stack.size() + 1] * 2;
                    p[stack.size() + 1] = 0;
                    break;

                default:
                    break;
            }
        }

        return p[0];
    }

    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        bw.write(String.valueOf(bracket(s)));

        bw.close();
        br.close();
    }

}
