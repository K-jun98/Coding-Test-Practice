package implement;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2504 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calculateBracketValue(input));
    }

    private static int calculateBracketValue(String s) {
        Stack<Character> stack = new Stack<>();
        int value = 0;
        int temp = 1;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    temp *= 2;
                    break;
                case '[':
                    stack.push('[');
                    temp *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return 0;
                    }
                    if (s.charAt(i - 1) == '(') {
                        value += temp;
                    }
                    stack.pop();
                    temp /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return 0;
                    }
                    if (s.charAt(i - 1) == '[') {
                        value += temp;
                    }
                    stack.pop();
                    temp /= 3;
                    break;
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }

        return value;
    }

}
