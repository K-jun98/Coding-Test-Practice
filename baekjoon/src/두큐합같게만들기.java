import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class 두큐합같게만들기 {

    public static void main(String[] args) throws IOException {
        두큐합같게만들기 s = new 두큐합같게만들기();
        int solution = s.solution(new int[]{1}, new int[]{1,2});
        System.out.println(solution);
    }

    public int solution(int[] q1, int[] q2) {
        long total = 0;
        long q1Total = 0;
        long q2Total = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < q1.length; i++) {
            total += q1[i];
            q1Total += q1[i];
            queue.add(q1[i]);
        }

        Queue<Integer> queue2 = new ArrayDeque<>();
        for (int i = 0; i < q2.length; i++) {
            total += q2[i];
            q2Total += q2[i];
            queue2.add(q2[i]);
        }


        int answer = 0;
        int count = q1.length+q2.length+1;
        while (q1Total != q2Total && count-- != 0) {
            if (q1Total > q2Total) {
                Integer value = queue.poll();
                queue2.add(value);
                q1Total -= value;
                q2Total += value;
                answer++;
            } else {
                Integer value = queue2.poll();
                queue.add(value);
                q2Total -= value;
                q1Total += value;
                answer++;
            }
        }
        answer = q1Total == q2Total ? answer :-1;
        return answer;
    }
}
