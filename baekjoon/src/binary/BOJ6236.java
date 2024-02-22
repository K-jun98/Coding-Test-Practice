package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int left = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]); // 모든 일자 중 최대 사용 금액
            sum += arr[i];
        }

        int right = sum;
        int answer = sum; // 최대값으로 초기화

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = getCount(arr, mid);

            if (count <= M) {
                answer = mid; // 조건을 만족하는 최소 mid 값을 찾음
                right = mid - 1; // 더 낮은 값을 찾기 위해 right 조정
            } else {
                left = mid + 1; // 더 많은 금액이 필요하므로 left 조정
            }
        }

        System.out.println(answer);
    }

    public static int getCount(int[] arr, int money) {
        int m = money;
        int count = 1; // 첫 인출 포함
        for (int value : arr) {
            if (m < value) {
                m = money; // 새로 인출
                count++;
            }
            m -= value; // 금액 사용
        }
        return count;
    }
}

