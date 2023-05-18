import java.util.Arrays;
import java.util.Scanner;

public class BOJ14503 {

    static int answer;
    static int X, Y, Dir;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[sc.nextInt()][sc.nextInt()];

        X = sc.nextInt();
        Y = sc.nextInt();
        Dir = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(l -> Integer.parseInt(l))
                    .toArray();
        }

        answer = 1;
        arr[X][Y] = 2;

        while (true) {
            if (check()) {
                continue;
            }
            if (arr[X - dx[Dir]][Y - dy[Dir]] == 1) {
                break;
            } else {
                X -= dx[Dir];
                Y -= dy[Dir];
            }
        }
        System.out.println(answer);
    }

    public static boolean check() {
        for (int i = 0; i < 4; i++) {
            Dir = (Dir + 3) % 4;
            int tempx = X + dx[Dir];
            int tempy = Y + dy[Dir];

            if (arr[tempx][tempy] == 0) {
                X = tempx;
                Y = tempy;
                arr[X][Y] = 2;
                answer++;
                return true;
            }
        }
        return false;
    }
}
