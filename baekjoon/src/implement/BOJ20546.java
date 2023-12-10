package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ20546 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int totalMoney;
    static int[] arr = new int[14];

    public static void main(String[] args) throws IOException {
        totalMoney = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bnp = BNP(totalMoney);
        int timing = TIMING(totalMoney);
        String answer = "SAMESAME";
        if (bnp > timing) {
            answer = "BNP";
        }
        if (timing > bnp) {
            answer = "TIMING";
        }
        System.out.println(answer);
    }

    public static int BNP(int totalMoney) {
        int money = totalMoney;
        int coin = 0;
        for (int i = 0; i < 14; i++) {
            if (arr[i] <= money && money != 0) {
                coin = money / arr[i];
                money = money % arr[i];
            }
        }
        return money + coin * arr[13];
    }

    public static int TIMING(int totalMoney) {
        int money = totalMoney;
        int coin = 0;
        for (int i = 3; i < 14; i++) {
            if (arr[i] > arr[i - 1] && arr[i - 1] > arr[i - 2] && arr[i - 2] > arr[i - 3] && coin!=0) {
                money += arr[i] * coin;
                coin =0;
            }
            if (arr[i] < arr[i - 1] && arr[i - 1] < arr[i - 2] && arr[i - 2] < arr[i - 3] && money != 0) {
                coin += money / arr[i];
                money = money % arr[i];
            }
        }
        return money + coin * arr[13];
    }

}
