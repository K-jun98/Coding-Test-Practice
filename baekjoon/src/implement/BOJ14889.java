package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] arr;
    static List<Integer> teamA = new ArrayList<>();
    static List<Integer> teamB = new ArrayList<>();
    static int N;

    static int small = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        makeTeam(0);
        System.out.println(small);
    }

    public static void makeTeam(int start) {
        if (teamA.size() == N / 2) {
            teamB.clear();
            for (int i = 0; i < N; i++) {
                if (!teamA.contains(i)) {
                    teamB.add(i);
                }
            }
            int i = makePoint();
            small = Math.min(small, i);
        }

        for (int i = start; i < N; i++) {
            teamA.add(i);
            makeTeam(i + 1);
            teamA.remove(teamA.size() - 1);
        }
    }

    public static int makePoint() {
        int tempA = 0;
        int tempB = 0;

        for (int i = 0; i < teamA.size() - 1; i++) {
            for (int j = i + 1; j < teamA.size(); j++) {
                tempA += arr[teamA.get(i)][teamA.get(j)] + arr[teamA.get(j)][teamA.get(i)];
                tempB += arr[teamB.get(i)][teamB.get(j)] + arr[teamB.get(j)][teamB.get(i)];
            }
        }
        return Math.abs(tempA - tempB);
    }
}
