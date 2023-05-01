import java.util.Scanner;

public class BOJ1018 {

    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;

    static String[] ans = new String[]{"WBWBWBWB", "BWBWBWBW"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                check(i, j, arr);
            }
        }
        System.out.println(answer);
    }

    private static void check(int startRow, int startCol, String[] arr) {
        int temp = 0;
        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int col = startCol + j;
                if (arr[row].charAt(col) != ans[row % 2].charAt(j)) {
                    temp++;
                }
            }
        }
        int min = Math.min(temp, Math.abs(64 - temp));
        answer = Math.min(answer, min);
    }
}
