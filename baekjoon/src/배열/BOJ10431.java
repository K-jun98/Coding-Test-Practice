package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sum = 0;
            String temp = st.nextToken();
            List<Integer> list = new ArrayList<>();
            list.add(Integer.valueOf(st.nextToken()));

            while (st.hasMoreTokens()) {
                Integer value = Integer.valueOf(st.nextToken());
                for (int j = list.size() - 1; j >= 0; j--) {
                    Integer i1 = list.get(j);
                    if (i1 <= value) {
                        list.add(j + 1, value);
                        break;
                    } else if (j == 0) {
                        sum++;
                        list.add(j, value);
                    } else {
                        sum++;
                    }
                }
            }
            System.out.println(temp + " " + sum);
        }
    }
}
