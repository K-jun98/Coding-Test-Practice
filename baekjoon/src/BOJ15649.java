import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ15649 {
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        matching(list);
    }

    private static void matching(List<Integer> list) {
        if (list.size() == M) {
            for (Integer k : list) {
                System.out.printf(k + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            matching(list);
            list.remove(list.size() - 1);
        }
    }
}

