import java.util.Scanner;

class Solution {
    private static final int MAX_LEVEL = 100; // 적절한 최대 레벨로 설정

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            int minGimbap = findMinGimbap(start, end);
            System.out.println("#" + test_case + " " + minGimbap);
        }
    }

    private static int findMinGimbap(int start, int end) {
        int[][] world = new int[MAX_LEVEL][];
        int counter = 1;

        // 2차원 배열을 채웁니다.
        for (int i = 0; i < MAX_LEVEL; i++) {
            world[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                world[i][j] = counter++;
            }
        }

        // 출발 지점과 도착 지점의 좌표를 찾습니다.
        int[] startPos = findPosition(start, world);
        int[] endPos = findPosition(end, world);

        // 좌표간 거리를 계산합니다.
        return Math.abs(startPos[0] - endPos[0]) + Math.abs(startPos[1] - endPos[1]);
    }

    private static int[] findPosition(int number, int[][] world) {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                if (world[i][j] == number) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // 찾지 못한 경우
    }
}
