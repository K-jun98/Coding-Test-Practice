import java.util.ArrayDeque;
import java.util.Queue;

public class 리코챗로봇 {

    public static void main(String[] args) {
        리코챗로봇 or = new 리코챗로봇();
        int solution = or.solution(new String[]{
                "...D..R", ".D.G...", "....D.D", "D....D.", "..D...."
        });

        System.out.println(solution);

    }

    int[] yArr = new int[]{-1, 0, 1, 0};
    int[] xArr = new int[]{0, -1, 0, 1};

    public int solution(String[] board) {
        char[][] arr = new char[board.length][board[0].length()];
        int[][] count = new int[board.length][board[0].length()];
        int[] start = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = board[i].charAt(j);
                start = arr[i][j] == 'R' ? new int[]{i, j} : start;
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        count[start[0]][start[1]] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            int cur = count[y][x];

            for (int i = 0; i < 4; i++) {
                int ny = y;
                int nx = x;
                while (true) {
                    ny += yArr[i];
                    nx += xArr[i];

                    if (ny < 0 || ny >= arr.length || nx < 0 || nx >= arr[0].length || arr[ny][nx] == 'D') {
                        ny -= yArr[i];
                        nx -= xArr[i];
                        if (arr[ny][nx] == 'G') {
                            return cur;
                        } else if (arr[ny][nx] == '.' && count[ny][nx] == 0) {
                            queue.add(new int[]{ny, nx});
                            count[ny][nx] = cur + 1;
                            break;
                        } else{
                            break;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
