public class 프렌즈4블록 {

    public static void main(String[] args) {
        프렌즈4블록 f = new 프렌즈4블록();
        int solution = f.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
        System.out.println(solution);
    }

    int om = 0;
    int on = 0;

    char[][] orig;
    boolean[][] copy;

    public int solution(int m, int n, String[] board) {
        this.om = m;
        this.on = n;

        orig = new char[m][n];
        copy = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                orig[i][j] = board[i].charAt(j);
            }
        }
        while (checkBlock()) {
            compact();
            copy = new boolean[m][n];
        }

        int answer = 0;
        for (int i = 0; i < orig.length; i++) {
            for (int j = 0; j < orig[0].length; j++) {
                answer += orig[i][j] == '.' ? 1 : 0;
            }
        }
        return answer;
    }

    public boolean checkBlock() {
        boolean check = false;
        for (int i = 0; i < om - 1; i++) {
            for (int j = 0; j < on - 1; j++) {
                if (orig[i][j]!='.' &&orig[i][j] == orig[i + 1][j] && orig[i][j] == orig[i][j + 1] && orig[i][j] == orig[i + 1][j + 1]) {
                    copy[i][j] = copy[i + 1][j] = copy[i][j + 1] = copy[i + 1][j + 1] = true;
                    check = true;
                }
            }
        }
        return check;
    }

    public void compact() {
        for (int i = 0; i < on; i++) { // x축
            int y = om-1;
            for (int j = om - 1; j >= 0; j--) { //y축

                if (!copy[j][i]) {
                    char temp = orig[j][i];
                    orig[j][i] = '.';
                    orig[y][i] = temp;
                    y--;
                } else {
                    orig[j][i] = '.';
                }
            }

            for (int j = y - 1; j >= 0; j--) {
                orig[j][i] = '.';
            }
        }
    }
}
