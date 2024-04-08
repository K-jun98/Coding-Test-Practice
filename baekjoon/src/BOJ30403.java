import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ30403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        System.out.println(Integer.valueOf('a'));
//        System.out.println(Integer.valueOf('A'));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        boolean[] upper = new boolean[26];
        boolean[] lower = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            Integer i1 = Integer.valueOf(s.charAt(i));
            if (i1 < 97) {
                upper[i1 - 65] = true;
                continue;
            }
            lower[i1 - 97] = true;
        }

        if (upper[17] && upper[14] && upper[24] && upper[6] && upper[1] && upper[8] && upper[21]
            && lower[17] && lower[14] && lower[24] && lower[6] && lower[1] && lower[8] && lower[21]) {
            System.out.println("YeS");
        } else if (upper[17] && upper[14] && upper[24] && upper[6] && upper[1] && upper[8] && upper[21]) {
            System.out.println("YES");
        } else if (lower[17] && lower[14] && lower[24] && lower[6] && lower[1] && lower[8] && lower[21]) {
            System.out.println("yes");
        } else {
            System.out.println("NO!");
        }
    }
}
