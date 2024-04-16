import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14426 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            strings.add(br.readLine());
        }

        List<String> search = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            search.add(br.readLine());
        }

        int answer = 0;

        for (int i = 0; i < search.size(); i++) {
            String s = search.get(i);

            for (int j = 0; j < strings.size(); j++) {
                String substring = strings.get(j).substring(0, s.length());
                if(substring.equals(s)){
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
