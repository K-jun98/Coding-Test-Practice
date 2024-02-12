import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String s = str.replaceAll("XXXX", "AAAA");
        String s1 = s.replaceAll("XX", "BB");

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c == 'X') {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(s1);
    }
}
