import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class N으로표현 {

    public static void main(String[] args) {
        N으로표현 n = new N으로표현();
        int solution = n.solution(5, 555);
        System.out.println(solution);
    }

    public int solution(int N, int number) {
        Set<Integer>[] sets = new Set[9];

        int value = N;
        sets[0] = new HashSet<>();
        for (int i = 1; i <= 8; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(value);
            value = value * 10 + N;
        }

        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int iValue : sets[j]) {
                    for (int jValue : sets[i - j]) {
                        sets[i].add(iValue * jValue);
                        sets[i].add(iValue + jValue);
                        sets[i].add(jValue - iValue);
                        sets[i].add(iValue - jValue);

                        if (jValue != 0) sets[i].add(iValue / jValue);
                    }
                }
            }
        }

        for (int i = 1; i <= 8; i++) {
            if (sets[i].contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
