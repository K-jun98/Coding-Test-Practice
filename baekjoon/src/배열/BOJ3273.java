package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[1000_001];
        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[value] = true;
        }
        int x = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 1; i <= (x - 1) / 2; i++) {
            if (i <= 1000000 && x - i <= 1000000) {
            answer += (arr[i] && arr[x - i]) ? 1 : 0;
            }
        }

        System.out.println(answer);
    }
}
