package implement;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ14888 {

    static int N;
    static int[] E;
    static int[] O = new int[4];

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        E = new int[N];
        E = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        O = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        makeValue(0, E[0]);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void makeValue(int index, int value) {
        if (index +1 == N) {
                System.out.println(Arrays.toString(O));
            MAX = Math.max(MAX, value);
            MIN = Math.min(MIN, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (O[i] != 0) {
                System.out.println(Arrays.toString(O));
                O[i]--;
                switch (i) {
                    case 0:
                        makeValue(index + 1, value + E[index + 1]);
                        break;
                    case 1:
                        makeValue(index + 1, value - E[index + 1]);
                        break;
                    case 2:
                        makeValue(index + 1, value * E[index + 1]);
                        break;
                    case 3:
                        makeValue(index + 1, value / E[index + 1]);
                }
                O[i]++;
            }

        }

    }

}
