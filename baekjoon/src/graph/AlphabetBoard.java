package graph;

import java.util.Scanner;

public class AlphabetBoard {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부
    static int[] dx = {-1, 1, 0, 0}; // 상, 하 이동
    static int[] dy = {0, 0, -1, 1}; // 좌, 우 이동
    static int maxCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = scanner.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(maxCount);
    }

    public static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[board[nx][ny] - 'A']) {
                    visited[board[nx][ny] - 'A'] = true;
                    dfs(nx, ny, count + 1);
                    visited[board[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}
