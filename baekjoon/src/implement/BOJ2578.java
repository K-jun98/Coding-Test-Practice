package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2578 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr = new int[6][6];
    static int temp;
    static int answer;
    static int count;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            arr[i] = Arrays.stream((br.readLine() + " 0").split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int value = Integer.parseInt(st.nextToken());
                findValueAndIncrease(value);
                if (count >= 3) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    public static void findValueAndIncrease(int value) {
        answer++;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == value) {
                    arr[i][5]++;
                    count += arr[i][5] == 5 ? 1 : 0;

                    arr[5][j]++;
                    count += arr[5][j] == 5 ? 1 : 0;

                    arr[5][5] += i == j ? 1 : 0;
                    count += arr[5][5] == 5 && i == j ? 1 : 0;

                    temp += i + j == 4 ? 1 : 0;
                    count += temp == 5 && i + j == 4 ? 1 : 0;
                    return;
                }
            }
        }
    }

}
