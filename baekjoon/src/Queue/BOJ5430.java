package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {
    static boolean isFlip = false;
    static boolean valid = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());


        while (T-- != 0) {
            char[] chars = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                deque.add(Integer.valueOf(st.nextToken()));
            }
            isFlip = false;
            valid = false;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                process(deque, c);
            }
            if (valid) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                while (!deque.isEmpty()) {
                    sb.append(isFlip ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                System.out.println("[" + sb + "]");
            }
        }

    }

    public static void process(Deque<Integer> deque, char c) {
        if (isFlip) {
            if (c == 'R') {
                isFlip = !isFlip;
            } else if (c == 'D') {
                if (deque.size() == 0) {
                    valid = true;
                    return;
                }
                deque.removeLast();
            }
        } else {
            if (c == 'R') {
                isFlip = !isFlip;
            } else if (c == 'D') {
                if (deque.size() == 0) {
                    valid = true;
                    return;
                }
                deque.removeFirst();
            }
        }
    }
}
