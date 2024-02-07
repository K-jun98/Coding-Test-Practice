import jdk.jfr.FlightRecorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class BOJ2751 {

    static int[] arr;

    static AtomicLong aa;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        aa.incrementAndGet();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        divide(0, N - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void divide(int start, int end) {
        if (start == end) return;

        int mid = (start + end) / 2;
        divide(start, mid);
        divide(mid + 1, end);
        combine(start, end);
    }

    private static void combine(int start, int end) {
        int mid = (start + end) / 2;
        int[] temp = new int[arr.length];

        int idx = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                temp[idx++] = arr[right++];
            } else {
                temp[idx++] = arr[left++];
            }
        }

        while (left <= mid) {
            temp[idx++] = arr[left++];
        }

        while (right <= end) {
            temp[idx++] = arr[right++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}

