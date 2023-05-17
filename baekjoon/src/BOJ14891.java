import java.util.*;

public class BOJ14891 {
    static int[][] arr = new int[4][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(k -> Integer.parseInt(k))
                    .toArray();
        }
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
            int idx = sc.nextInt();
            int dir = sc.nextInt();
            turn(idx - 1, dir);
        }
        int[] scores = new int[]{1, 2, 4, 8};
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                answer += scores[i];
            }
        }
        System.out.println(answer);
    }

    private static void turn(int idx, int dir) {
        int[] dirs = new int[4];
        dirs[idx] = dir;
        for (int i = idx; i < 3; i++) {
            if (arr[i][2] != arr[i + 1][6]) {
                dirs[i + 1] = -dirs[i];
            } else {
                break;
            }
        }
        for (int i = idx; i > 0; i--) {
            if (arr[i][6] != arr[i - 1][2]) {
                dirs[i - 1] = -dirs[i];
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            int temp = 0;
            if (dirs[i] == 1) {
                temp = arr[i][7];
                for (int j = 7; j > 0; j--) {
                    arr[i][j] = arr[i][j - 1];
                }
                arr[i][0] = temp;
            } else if (dirs[i] == -1) {
                temp = arr[i][0];
                for (int j = 0; j < 7; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][7] = temp;
            }
        }
    }
}
