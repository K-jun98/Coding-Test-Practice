package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14503 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static int[] cur;
    static int[] yArr = new int[]{-1, 0, 1, 0};
    static int[] xArr = new int[]{0, 1, 0, -1};

    static int answer = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(br.readLine());
        cur = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        arr[cur[0]][cur[1]] = 2;

        while (true) {
            if (check()) {
                continue;
            }
            int dy = cur[0] - yArr[cur[2]];
            int dx = cur[1] - xArr[cur[2]];


            if (arr[dy][dx] == 1) {
                break;
            }else{
                cur[0] = dy;
                cur[1] = dx;
            }
        }

        System.out.println(answer);


    }

    private static boolean check() {
        int d = cur[2];
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int dy = cur[0] + yArr[d];
            int dx = cur[1] + xArr[d];
            if ( arr[dy][dx] == 0) {
                arr[dy][dx] = 2;
                cur[0] = dy;
                cur[1] = dx;
                cur[2] = d;
                answer++;
                return true;
            }
        }
        return false;
    }
}
