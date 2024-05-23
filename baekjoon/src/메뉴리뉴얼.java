import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼 {

    Map<String, Integer> count = new HashMap<>();
    List<String> list = new ArrayList<>();
    int[] maxArr = new int[11];

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        메뉴리뉴얼 m = new 메뉴리뉴얼();
        m.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
    }*/

    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            comb(chars, "", 0);
        }

        for (int v : course) {
            addMaxCourse(v);
        }

        Collections.sort(list);

        list.forEach(System.out::println);
        String[] array = list.stream().toArray(x -> new String[x]);
        return array;
    }

    public void comb(char[] chars, String now, int inx) {
        for (int i = inx; i < chars.length; i++) {
            String s = now + chars[i];

            if (s.length() > 1) {
                Integer value = count.getOrDefault(s, 0);
                count.put(s, value + 1);
                maxArr[s.length()] = maxArr[s.length()] < value + 1 ? value + 1 : maxArr[s.length()];
            }
            comb(chars, s, i + 1);
        }
    }

    public void addMaxCourse(int length) {
        count.entrySet().stream().filter(x -> x.getKey().length() == length && x.getValue() > 1 && x.getValue() == maxArr[length]).forEach(x -> list.add(x.getKey()));
    }
}
