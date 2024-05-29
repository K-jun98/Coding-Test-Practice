import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 택배상자 {

    public static void main(String[] args) {
        택배상자 t = new 택배상자();
        int solution = t.solution(new int[]{4,5,3,2,1,6,7});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] order) {
        Queue<Integer> queue = new ArrayDeque();
        for(int i =0; i<order.length; i++) {
            queue.add(i+1);
        }

        Stack<Integer> stack = new Stack();
        int answer = 0;
        for(int i =0; i<order.length; i++){
            int v = order[i];
            if(!stack.isEmpty() && stack.peek() == v) {
                stack.pop();
                answer++;
            }else if(!queue.isEmpty() && queue.peek() == v) {
                queue.poll();
                answer++;
            } else if (!queue.isEmpty() && queue.peek() < v) {
                stack.push(queue.poll());
                i--;
            } else {
            break;
            }
        }

        return answer;
    }
}
