import static java.util.stream.Collectors.toList;

import java.util.*;

public class BOJ20546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = Integer.parseInt(sc.nextLine());
        int price2 = price;
        int coin1 = 0;
        List<Integer> list = Arrays.stream(sc.nextLine().split(" "))
                .map(k -> Integer.parseInt(k))
                .collect(toList());
        for (int i = 0; i < list.size(); i++) {
            if (price >= list.get(i)) {
                coin1 += price / list.get(i);
                price %= list.get(i);
            }
        }
        int BNP = coin1 * list.get(list.size() - 1) + price;

        int coin2 = 0;
        for (int i = 3; i < list.size(); i++) {
            if (list.get(i - 3) > list.get(i - 2) && list.get(i - 2) > list.get(i - 1) && list.get(i - 1) > list.get(
                    i)) {
                coin2 += price2 / list.get(i);
                price2 %= list.get(i);
            } else if (list.get(i - 3) < list.get(i - 2) && list.get(i - 2) < list.get(i - 1)
                    && list.get(i - 1) < list.get(i)) {
                price2 += list.get(i) * coin2;
                coin2 = 0;
            }
        }
        int TIMING = coin2 * list.get(list.size() - 1) + price2;

        if (BNP > TIMING) {
            System.out.println("BNP");
        } else if (BNP < TIMING) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
