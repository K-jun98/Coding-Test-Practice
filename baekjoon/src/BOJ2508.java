import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2508 {

    static char[][] arr;
    static int[] yArr = new int[]{-1, 0, 1, 0};
    static int[] xArr = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int answer = 0;
            for (int i1 = 0; i1 < N; i1++) {
                for (int i2 = 0; i2 < M; i2++) {
                    if (arr[i1][i2] == 'o' && isCandy(i1, i2)) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    private static boolean isCandy(int i1, int i2) {
        int upY = i1 + yArr[0];
        int downY = i1 + yArr[2];

        int leftX = i2 + xArr[1];
        int rightX = i2 + xArr[3];
        if (upY >= 0 && upY < arr.length && downY >= 0 && downY < arr.length && arr[upY][i2] == 'v' && arr[downY][i2] == '^') {
            return true;
        } else if (leftX >= 0 && leftX < arr[0].length && rightX >= 0 && rightX < arr[0].length && arr[i1][leftX] == '>' && arr[i1][rightX] == '<') {
            return true;
        }
        return false;
    }
}
