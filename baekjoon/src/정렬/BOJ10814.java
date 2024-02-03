package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        String[][] strs = new String[N][2];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            strs[i][0] = st.nextToken();
            strs[i][1] = st.nextToken();
        }

        Arrays.sort(strs, (o1, o2) ->
                Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]))
        );


        for (int i = 0; i < N; i++) {
            System.out.println(strs[i][0] + " " + strs[i][1]);
        }
    }

}
