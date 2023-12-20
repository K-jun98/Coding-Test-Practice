package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16926 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int[][] answer;
    static List<List<Integer>> total = new ArrayList<>();
    static int R = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int small = Math.min(N, M);

        arr = new int[N][M];
        answer = new int[N][M];
        // 값 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < small / 2; i++) {
            inputLine(0 + i, 0 + i, N - 1 - i, M - 1 - i);
        }
        change();

        for (int i = 0; i < small / 2; i++) {
            inputAnswer(0 + i, 0 + i, N - 1 - i, M - 1 - i, total.get(i));
        }

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.printf(String.valueOf(answer[i][j]+" "));
            }
            System.out.println();
        }
    }

    public static void inputLine(int y, int x, int endY, int endX) {
        List<Integer> list = new ArrayList<>();

        for (int i = x; i < endX; i++) {
            list.add(arr[y][i]);
        }
        for (int i = y; i < endY; i++) {
            list.add(arr[i][endX]);
        }
        for (int i = endX; i > x; i--) {
            list.add(arr[endY][i]);
        }
        for (int i = endY; i > y; i--) {
            list.add(arr[i][x]);
        }
        total.add(list);
    }

    public static void inputAnswer(int y, int x, int endY, int endX, List<Integer> values) {
        for (int i = x; i < endX; i++) {
            answer[y][i] = values.remove(0);
        }
        for (int i = y; i < endY; i++) {
            answer[i][endX] = values.remove(0);
        }
        for (int i = endX; i > x; i--) {
            answer[endY][i] = values.remove(0);
        }
        for (int i = endY; i > y; i--) {
            answer[i][x] = values.remove(0);
        }
    }

    private static void change() {
        for (int i = 0; i < total.size(); i++) {
            List<Integer> integers = total.get(i);
            int value = R % integers.size();
            for (int j = 0; j < value; j++) {
                total.get(i).add(total.get(i).remove(0));
            }
        }
    }

}
