import java.util.ArrayDeque;
import java.util.Queue;

public class 미로탈출 {

    public static void main(String[] args) {
        미로탈출 ms = new 미로탈출();
        int solution = ms.solution(new String[]{
                "LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"
        });

        System.out.println("solution = " + solution);
    }

    int[] yArr = new int[]{-1, 0, 1, 0};
    int[] xArr = new int[]{0, -1, 0, 1};

    public int solution(String[] maps) {
        int answer = 0;

        char[][] arr = new char[maps.length][maps[0].length()];
        int[][] lCount = new int[maps.length][maps[0].length()];
        int[][] eCount = new int[maps.length][maps[0].length()];

        int[] start = new int[2];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                arr[i][j] = maps[i].charAt(j);
                start = arr[i][j] == 'S' ? new int[]{i, j} : start;
            }
        }

        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{start[0], start[1]});
        lCount[start[0]][start[1]] = 1;
        boolean check1 = false;
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dy = poll[0] + yArr[i];
                int dx = poll[1] + xArr[i];

                if (dy >= 0 && dy < arr.length && dx >= 0 && dx < arr[0].length && lCount[dy][dx] == 0) {
                    if (arr[dy][dx] == 'O' || arr[dy][dx] == 'E') {
                        queue.add(new Integer[]{dy, dx});
                        lCount[dy][dx] = lCount[poll[0]][poll[1]] + 1;
                    } else if (arr[dy][dx] == 'L') {
                        answer += lCount[poll[0]][poll[1]];
                        start = new int[]{dy, dx};
                        queue.clear();
                        check1 = true;
                        break;
                    }
                }
            }
        }
        boolean check = false;
        queue.add(new Integer[]{start[0], start[1]});
        eCount[start[0]][start[1]] = 1;
        while (!queue.isEmpty() && check == false && check1 == true) {
            Integer[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dy = poll[0] + yArr[i];
                int dx = poll[1] + xArr[i];

                if (dy >= 0 && dy < arr.length && dx >= 0 && dx < arr[0].length && eCount[dy][dx] == 0) {
                    if (arr[dy][dx] == 'O' || arr[dy][dx] == 'S') {
                        queue.add(new Integer[]{dy, dx});
                        eCount[dy][dx] = eCount[poll[0]][poll[1]] + 1;
                    } else if (arr[dy][dx] == 'E') {
                        answer += eCount[poll[0]][poll[1]];
                        check = true;
                        break;
                    }
                }
            }
        }
        return check ? answer : -1;
    }
}
