import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {

    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);

        recursive(arr, 0, "", 0);
    }

    public static void recursive(String[] arr, int count, String value, int idx) {
        if (count == M) {
            System.out.println(value.trim());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            recursive(arr, count + 1, value + " " + arr[i], i);
        }
    }
}
