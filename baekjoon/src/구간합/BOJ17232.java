package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17232 {
    static char[][] arr;
    static int[][] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 첫번째 줄 입력
        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); //가로
        int T = Integer.parseInt(st.nextToken()); //횟수

        st = new StringTokenizer(br.readLine()); // 두번째 줄 입력
        int K = Integer.parseInt(st.nextToken()); // 테두리 기준
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        arr = new char[N + 1][N + 1];
        arr2 = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                char c = str.charAt(j - 1);
                arr[i][j] = c;
                int value = c == '*' ? 1 : 0;
                arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1] + value;
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(arr2));
        while (T-- > 0) {
            int[][] curArr = arr2;

            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr[0].length; j++) {
                    int curLive = arr[i][j] == '*' ? 1 : 0;
                    int value = getRange(curArr, i, j, K) - curLive; //주위의 생명 갯수 + 현재위치 생명 수
                    if (curLive == 1) {
                        if (value >= A && value <= B) {
                            arr[i][j] = '*';
                            arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1] + curLive;
                        } else if (value < A) {
                            arr[i][j] = '.';
                            arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1];
                        } else if (value > B) {
                            arr[i][j] = '.';
                            arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1];
                        }
                    } else if (curLive == 0 && value > A && value <= B) {
                        arr[i][j] = '*';
                        arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1] + curLive;
                    }
                }
            } 

            System.out.println(Arrays.deepToString(arr));
            System.out.println(Arrays.deepToString(arr2));

        }

    }

    public static int getRange(int[][] arr, int y, int x, int k) {
        int y1 = Math.max(1, y - k);
        int x1 = Math.max(1, x - k);
        int y2 = Math.min(arr.length - 1, y + k);
        int x2 = Math.min(arr[0].length - 1, x + k);
        return arr[y2][x2] - arr[y2][x1] - arr[y1][x2] + arr[y1][x1];
    }

}
