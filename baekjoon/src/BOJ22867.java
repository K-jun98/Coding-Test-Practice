import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ22867 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            list.add(new String[]{strings[0], "1"});
            list.add(new String[]{strings[1], "-1"});
        }

        Collections.sort(list, (x1,x2)->{
            if (x1[0].equals(x2[0])) {
                return Integer.parseInt(x1[1]) - Integer.parseInt(x2[1]);
            }
            return x1[0].compareTo(x2[0]);
        });

        int answer = 0;
        int cur =0;
        for (int i = 0; i < list.size(); i++) {
            String[] strings = list.get(i);
//            System.out.println(strings[1]);
            cur += Integer.parseInt(strings[1]);
            answer=Math.max(answer, cur);
        }

        System.out.println(answer);
    }
}
