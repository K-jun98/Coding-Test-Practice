
class TTTest_1 {

    public int solution(String s) {
        for (int num = 999; num >= 111; num -= 111) {
            if (s.contains(String.valueOf(num))) {
                return num;
            }
        }
        if (s.contains("000")) {
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        TTTest_1 toss = new TTTest_1();
        int solution = toss.solution("12223");
        System.out.println(solution);
        int solution1 = toss.solution("000");
        System.out.println(solution1);
    }
}
