import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int cnt;
    static int[] values;
    static int[] oper = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = Integer.parseInt(br.readLine());
        values = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cnt; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(values[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int value, int ind) {
        if (ind == cnt) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (oper[i] > 0) {
                oper[i]--;

                switch (i) {
                    case 0:
                        dfs(value + values[ind], ind + 1);
                        break;
                    case 1:
                        dfs(value - values[ind], ind + 1);
                        break;
                    case 2:
                        dfs(value * values[ind], ind + 1);
                        break;
                    case 3:
                        dfs(value / values[ind], ind + 1);
                        break;
                }
                oper[i]++;
            }
        }
    }
}
