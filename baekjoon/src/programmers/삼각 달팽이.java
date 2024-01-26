package programmers;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[] yArr = new int[]{1, 0, -1};
        int[] xArr = new int[]{0, 1, -1};
        boolean check = false;

        int y = 0, x = 0, d = 0, v = 2;
        arr[0][0] = 1;
        while (true) {
            int dy = y + yArr[d % 3];
            int dx = x + xArr[d % 3];

            if (dy >= 0 && dy < n && dx >= 0 && dx < n) {
                if (arr[dy][dx] == 0) {
                    check = false;
                    arr[dy][dx] = v++;
                    y = dy;
                    x = dx;
                } else {
                    if (check) {
                        break;
                    }
                    check = true;
                    d++;
                }
            } else {
                if (check) {
                    break;
                }
                check = true;
                d++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                list.add(arr[i][j]);
            }
        }
        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        return array;
    }
}
