import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[1_000_001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i < arr.length; i++) {
            arr[i] = (int) ((1L*arr[i - 1] + arr[i - 2] + arr[i - 3]) % 1000000009);
        }
        while (T-- > 0) {

            int value = Integer.parseInt(br.readLine());


            System.out.println(arr[value]);
        }

    }
}
