import java.util.Arrays;
import java.util.Scanner;

public class BOJ2578 {
    static int answer = 0;
    static int count = 0;
    static int temp = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[6][6];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < 25; k++) {
            int str = sc.nextInt();
            answer++;
            findNum(arr, str);
            System.out.println(Arrays.deepToString(arr));
            if (count >= 3) {
                System.out.println(answer);
                return;
            }
        }
    }

    public static void findNum(int[][] arr, int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == num) {
                    arr[5][j] += 1;
                    count += (arr[5][j]) == 5 ? 1 : 0;

                    arr[i][5] += 1;
                    count += (arr[i][5]) == 5 ? 1 : 0;

                    arr[5][5] += (i == j) ? 1 : 0;
                    if (i == j && arr[5][5] == 5) {
                        count++;
                    }
                    temp += (i + j) == 4 ? 1 : 0;
                    if (i + j == 4 && temp == 5) {
                        temp++;
                        count++;
                    }
                    return;
                }
            }
        }
    }
}
