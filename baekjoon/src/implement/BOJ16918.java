package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16918 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] arr;
    static List<char[][]> list = new ArrayList<>();
    static int[] yArr = new int[]{1, 0, -1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        if (N % 2 == 0) {
            char[][] chars = makeDefaultMap();
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[0].length; j++) {
                    System.out.printf(String.valueOf(chars[i][j]));
                }
                System.out.println();
            }
            return;
        }
        list.add(arr);
        for (int i = 1; i <= N; i += 2) {
            changeMap(list.get(list.size() - 1));
        }

        char[][] a = list.get(list.size() - 2);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf(String.valueOf(a[i][j]));
            }
            System.out.println();
        }
    }

    public static void changeMap(char[][] arr) {
        char[][] map = makeDefaultMap();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'O') {
                            map[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int dy = i + yArr[k];
                        int dx = j + xArr[k];
                        if (dy >= 0 && dy < arr.length && dx >= 0 && dx < arr[0].length) {
                            map[dy][dx] = '.';
                        }
                    }
                }
            }
        }
        list.add(map);
    }

    public static char[][] makeDefaultMap() {
        char[][] map = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                map[i][j] = 'O';
            }
        }
        return map;
    }
}



