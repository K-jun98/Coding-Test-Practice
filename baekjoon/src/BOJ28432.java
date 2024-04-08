import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ28432 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(s);
            if (s.equals("?")) {
                index = i;
            }
        }

        int M = Integer.parseInt(br.readLine());

        if (list.size() == 1) {
            System.out.println(br.readLine());
            return;
        }

        if (index == 0) {
            char nextStart = list.get(1).charAt(0);
            for (int i = 0; i < M; i++) {
                String s = br.readLine();
                if (nextStart == s.charAt(s.length() - 1) && !list.contains(s)) {
                    System.out.println(s);
                    return;
                }
            }
        } else if (index == list.size() - 1) {
            char start = list.get(list.size() - 2).charAt(list.get(list.size() - 2).length() - 1);
            for (int i = 0; i < M; i++) {
                String s = br.readLine();
                if (start == s.charAt(0) && !list.contains(s)) {
                    System.out.println(s);
                    return;
                }
            }
        } else {
            char nextStart = list.get(index + 1).charAt(0);
            char start = list.get(index - 1).charAt(list.get(index - 1).length() - 1);
            for (int i = 0; i < M; i++) {
                String s = br.readLine();
                if (start == s.charAt(0) && nextStart == s.charAt(s.length() - 1) && !list.contains(s)) {
                    System.out.println(s);
                    return;
                }
            }
        }
    }
}
