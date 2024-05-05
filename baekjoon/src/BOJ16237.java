import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16237 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = arr[5];

        answer += arr[4];
        arr[1] -= Math.min(arr[1], arr[4]);


        int min3 = Math.min(arr[3], arr[2]);
        answer += min3;
        arr[3] -= min3;
        arr[2] -= min3;

        if (arr[3] > 0) {
            answer += arr[3];
            arr[1] -= Math.min(arr[1], arr[3] * 2);
        }

        int answer1 = arr[2] / 2;
        answer += answer1;
        arr[2] -= answer1*2;
        arr[1] -= Math.min(answer1, arr[1]);
        if (arr[2] > 0) {
            answer += arr[2];
            arr[1] -= Math.min(arr[2] * 3, arr[1]);
        }

        answer += Math.ceil(arr[1] / 5);

        System.out.println(answer);
    }
}
