import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ31496 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        String value = st.nextToken();

        int total = 0;
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());

            String word = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());

            String[] strings = word.split("_");
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals(value)) {
                    total += amount;
                    break;
                }
            }
        }

        System.out.println(total);
    }
}
