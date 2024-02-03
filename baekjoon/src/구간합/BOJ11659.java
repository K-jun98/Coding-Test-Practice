package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(3^2);
        System.out.println(3^2);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) + 1;
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        // N번
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = arr[Integer.valueOf(st.nextToken())-1];
            int i2 = arr[Integer.valueOf(st.nextToken())];
            System.out.println(i2-i1);
        }
    }

}
