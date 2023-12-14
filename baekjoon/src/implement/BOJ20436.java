package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20436 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] 자음 = {{'q', 'w', 'e', 'r', 't', '.', '.', '.', '.', '.'},
            {'a', 's', 'd', 'f', 'g', '.', '.', '.', '.', '.'},
            {'z', 'x', 'c', 'v', '.', '.', '.', '.', '.', '.'}};

    static char[][] 모음 = {{'.', '.', '.', '.', '.', 'y', 'u', 'i', 'o', 'p'},
            {'.', '.', '.', '.', '.', 'h', 'j', 'k', 'l', '.'},
            {'.', '.', '.', '.', 'b', 'n', 'm', '.', '.', '.'}};

    static char L;
    static int Lx;
    static int Ly;

    static char R;
    static int Rx;
    static int Ry;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = st.nextToken().charAt(0);
        R = st.nextToken().charAt(0);

        firstChar(L);
        firstChar(R);

        int sum = 0;
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int aChar = findChar(c);
            sum += aChar;
        }
        System.out.println(sum);
    }

    public static int findChar(char ch) {
        for (int i = 0; i < 자음.length; i++) {
            for (int j = 0; j < 자음[0].length; j++) {
                if (자음[i][j] == ch) {
                    int lTemp = Math.abs(i - Ly) + Math.abs(j - Lx) + 1;
                    Ly = i;
                    Lx = j;
                    return lTemp;
                }
                if (모음[i][j] == ch) {
                    int rTemp = Math.abs(i - Ry) + Math.abs(j - Rx) + 1;
                    Ry = i;
                    Rx = j;
                    return rTemp;
                }
            }
        }
        return 0;
    }

    public static void firstChar(char ch) {
        for (int i = 0; i < 자음.length; i++) {
            for (int j = 0; j < 자음[0].length; j++) {
                if (자음[i][j] == ch) {
                    Ly = i;
                    Lx = j;
                }
                if (모음[i][j] == ch) {
                    Ry = i;
                    Rx = j;
                }
            }
        }
    }

}
