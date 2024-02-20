import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5211 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("\\|");

        int 다장조 = 0;
        int 가단조 = 0;

        String string = "";

        for (int i = 0; i < strings.length; i++) {
            string = strings[i];
            char c = string.charAt(0);
            if (c == 'A' || c == 'D' || c == 'E') {
                가단조++;

            } else if (c == 'C' || c == 'F' || c == 'G') {
                다장조++;
            }

            if (i == strings.length - 1 && 다장조 == 가단조) {
                char c1 = string.charAt(string.length() - 1);
                if (c1 == 'A' || c1 == 'D' || c1 == 'E') {
                    가단조++;

                } else if (c1 == 'C' || c1 == 'F' || c1 == 'G') {
                    다장조++;
                }
            }
        }

        if (다장조 > 가단조) {
            System.out.println("C-major");
        } else {
            System.out.println("A-minor");
        }
    }
}
