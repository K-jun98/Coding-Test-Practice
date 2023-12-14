package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ15721 {

    private static final String 뻔 = "뻔";
    private static final String 데기 = "데기";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> list = new ArrayList<>();
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        String find = br.readLine().equals("1") ? 데기 : 뻔;

        while (true) {
            for (int i = 0; i < A; i++) {
                if (list.isEmpty()) {
                    뻔데기();
                }
                String remove = list.remove(0);
                if (remove.equals(find)) {
                    T--;
                    if (T == 0) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }

    public static void 뻔데기() {
        list.add(뻔);
        list.add(데기);
        list.add(뻔);
        list.add(데기);
        for (int i = 0; i < cnt + 1; i++) {
            list.add(뻔);
        }
        for (int i = 0; i < cnt + 1; i++) {
            list.add(데기);
        }
        cnt++;
    }

}
