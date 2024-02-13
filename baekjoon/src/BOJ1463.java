import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1_000_001];
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i < arr.length; i++) {
            int a = i % 3 == 0 ? arr[i / 3] + 1 : Integer.MAX_VALUE;
            int b = i % 2 == 0 ? arr[i / 2] + 1 : Integer.MAX_VALUE;
            int c = arr[i - 1] + 1;

            int value = Math.min(Math.min(a, b), c);
            arr[i] = value;
        }

        System.out.println(arr[N]);
    }
}
