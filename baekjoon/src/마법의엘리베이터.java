import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 마법의엘리베이터 {

    public static void main(String[] args) {
        마법의엘리베이터 m = new 마법의엘리베이터();
        int solution = m.solution(555);
        System.out.println(solution);
    }

    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;
            storey /= 10;

            if (digit == 5) {
                if (storey % 10 >= 5) {
                    answer += 5;
                    storey++;
                } else {
                    answer += 5;
                }
            } else if (digit < 5) {
                answer += digit;
            } else {
                answer += (10 - digit);
                storey++;
            }
        }
        return answer;
    }
}
