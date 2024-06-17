import java.util.HashSet;

class TTest_1 {
    HashSet<String> set = new HashSet<>();
    boolean[] check = new boolean[0];

    public int solution(String S, int N) {
        check = new boolean[N + 1];
        int max = -1;
        comb("");

        for (int i = 0; i < S.length() - N +1; i++) {
            String substring = S.substring(i, i + N);
            if (set.contains(substring)) { // 찾는 시간복잡도 줄이기 위해 hashset 사용
                max = Math.max(Integer.parseInt(substring), max);
            }

        }
        System.out.println(max);
        return max;
    }

    //N으로 만들 수 있는 수 생성 O(n!) 최대 약 10^9
    public void comb(String value) {
        if (value.length() == check.length-1) {
            set.add(value);
            return;
        }
        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                check[i] = true;
                comb(value + i);
                check[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        TTest_1 toss = new TTest_1();
        toss.solution("1451232125", 2);
        toss.solution("313253123", 3);
        toss.solution("543261", 5);
    }
}
