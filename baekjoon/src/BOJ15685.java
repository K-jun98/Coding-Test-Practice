import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15685 {
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> dir = new ArrayList<>();
            dir.add(d);
            for (int j = 0; j < g; j++) {
                for (int k = dir.size() - 1; k >= 0; k--) {
                    dir.add((dir.get(k) + 1) % 4);
                }
            }

            map[x][y] = true;
            for (Integer direction : dir) {
                x += dx[direction];
                y += dy[direction];
                map[x][y] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
