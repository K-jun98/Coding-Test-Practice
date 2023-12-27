package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2529 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K;
    static char[] symbol;
    static List<Integer> list = new ArrayList<>();

    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static String answerMAX;
    static String answerMIN;
    static boolean[] check = new boolean[10];

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        symbol = new char[K];
        for (int i = 0; i < K; i++) {
            symbol[i] = st.nextToken().charAt(0);
        }

        find();
        System.out.println(answerMAX);
        System.out.println(answerMIN);
    }

    public static void find() {
        if (list.size() == K + 1) {
            for (int i = 0; i < symbol.length; i++) {
                boolean right = right(list.get(i), symbol[i], list.get(i + 1));
                if (right) {
                    if (i == symbol.length - 1) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < list.size(); j++) {
                            sb.append(list.get(j));
                        }
                        long value = Long.parseLong(sb.toString());
                        if (max < value) {
                            max = value;
                            answerMAX = sb.toString();
                        }
                        if (min > value) {
                            min = value;
                            answerMIN = sb.toString();
                        }
                    }
                } else {
                    return;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                list.add(i);
                check[i] = true;
                find();
                check[i] = false;
                list.remove(list.size() - 1);
            }
        }

    }

    public static boolean right(int prev, char ch, int next) {
        switch (ch) {
            case '>':
                return prev > next;
            case '<':
                return prev < next;
            default:
                return false;
        }
    }

}
