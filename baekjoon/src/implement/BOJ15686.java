package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
치킨거리는 집과 가장 가까운 치킨집 사이의 거리
도시의 치킨 거리는 모든 집의 치킨 거리의 합
도시에 있는 치킨집 중에서 최대 M개를 고르고 나머지는 폐업
어떻게 고르면 도시의 치킨 거리가 가장 작게될 지 구하는 프로그램 작성
 */

public class BOJ15686 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> tempChicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static int M;

    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 치킨집이랑 집 좌표 저장
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    house.add(new int[]{i, j});
                }
                if (value == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        calculate(0, 0);
        System.out.println(answer);
    }

    public static void calculate(int index, int count) {
        if (count == M) {
            int small = calculateCityDist();
            answer = Math.min(small, answer);
            return;
        }
        for (int i = index; i < chicken.size(); i++) {
            tempChicken.add(chicken.get(i));
            calculate(i + 1, count + 1);
            tempChicken.remove(tempChicken.size() - 1);
        }
    }

    //도시치킨거리
    public static int calculateCityDist() {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            sum += getHouseChickenDist(house.get(i));
        }
        return sum;
    }

    // 치킨거리
    private static int getHouseChickenDist(int[] house) {
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < tempChicken.size(); i++) {
            int[] chicken = tempChicken.get(i);
            int temp = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
            small = Math.min(temp, small);
        }
        return small;
    }

}
