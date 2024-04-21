import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(list);

        int front = 0;
        int three = list.get(2) - list.get(0);
        int back = 0;
        for (int i = 3; i < N - 1; i += 2) {
            back += list.get(i + 1) - list.get(i);
        }

        long min = (long)front + three + back;

        for (int i = 2; i < N - 2; i+=2) {
            front += list.get(i - 1) - list.get(i - 2);
            three = list.get(i + 2) - list.get(i);
            back -= list.get(i + 2) - list.get(i + 1);

            min = Math.min(min, (long) front + three + back);
        }
        System.out.println(min);
    }
}
