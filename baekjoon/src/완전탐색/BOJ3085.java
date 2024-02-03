package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
