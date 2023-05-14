import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1145 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[5];
        int num = 1;
        int temp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            num++;
            temp = 0;
            for (int i = 0; i < 5; i++) {
                if (num % numArr[i] == 0) {
                    temp++;
                }
            }
            if (temp >= 3) {
                break;
            }
        }
        System.out.println(num);
    }
}
