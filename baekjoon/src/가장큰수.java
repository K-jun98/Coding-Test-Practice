import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {

    public static void main(String[] args) {
        가장큰수 k = new 가장큰수();
        String solution = k.solution(new int[]{6, 10, 2});
        System.out.println(solution);
    }

    public String solution(int[] numbers) {
        List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        String answer ="";

        for (int i = 0; i < list.size(); i++) {
            answer += String.valueOf(list.get(i));
        }

        return answer;
    }
}
