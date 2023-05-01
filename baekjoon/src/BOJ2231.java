import java.util.Scanner;

public class BOJ2231 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(check(N));

    }

    private static int check(int N) {
        for (int i = 0; i < N; i++) {
            int temp = i;
            int sum = i;
            while (temp != 0) {
                sum+=temp%10;
                temp = temp / 10;
            }
            if (sum == N) {
                return i;
            }

        }
        return 0;
    }
}
