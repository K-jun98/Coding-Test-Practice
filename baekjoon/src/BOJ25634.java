import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ25634 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        int[] switchs = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                switchs[i] = -arr[i];
                total += arr[i];
            } else {
                switchs[i] = arr[i];
            }
        }

        int cur = switchs[0];
        int max = switchs[0];
        for (int i = 1; i < n; i++) {
            cur = Math.max(cur + switchs[i], switchs[i]);
            max = Math.max(max, cur);
        }

//        System.out.println(total);
        System.out.println(max + total);
    }
}
