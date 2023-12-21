package implement;

import java.util.Scanner;

public class BOJ2503 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] queries = new int[n][3];

        for (int i = 0; i < n; i++) {
            queries[i][0] = scanner.nextInt(); // 민혁이가 질문한 숫자
            queries[i][1] = scanner.nextInt(); // 스트라이크 개수
            queries[i][2] = scanner.nextInt(); // 볼의 개수
        }

        int count = 0;
        for (int i = 123; i <= 987; i++) {
            if (isValidNumber(i) && matchesAllQueries(i, queries)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isValidNumber(int number) {
        int first = number / 100;
        int second = (number / 10) % 10;
        int third = number % 10;
        return first != second && first != third && second != third && first != 0 && second != 0 && third != 0;
    }

    private static boolean matchesAllQueries(int number, int[][] queries) {
        for (int[] query : queries) {
            if (matchesQuery(number, query[0], query[1], query[2])) {
                return true;
            }
        }
        return false;
    }

    private static boolean matchesQuery(int number, int guess, int strikes, int balls) {
        int strikeCount = 0;
        int ballCount = 0;

        int[] numberDigits = {number / 100, (number / 10) % 10, number % 10};
        int[] guessDigits = {guess / 100, (guess / 10) % 10, guess % 10};

        for (int i = 0; i < 3; i++) {
            if (numberDigits[i] == guessDigits[i]) {
                strikeCount++;
            } else if (numberDigits[i] == guessDigits[(i + 1) % 3] || numberDigits[i] == guessDigits[(i + 2) % 3]) {
                ballCount++;
            }
        }

        return strikeCount == strikes && ballCount == balls;
    }

}
