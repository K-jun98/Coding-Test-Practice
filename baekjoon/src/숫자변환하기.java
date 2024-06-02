import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 숫자변환하기 {

    public int solution(int x, int y, int n) {
        if(x==y){
            return 0;
        }

        int[] arr = new int[1_000_001];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[x]=0;
        Queue<Integer> queue = new ArrayDeque();
        queue.add(x);

        while(!queue.isEmpty()){
            int poll = queue.poll();

            int x1 = poll + n;
            int x2 = poll * 2;
            int x3 = poll * 3;

            if((x2 <= y && arr[x2] == Integer.MAX_VALUE)){
                arr[x2] = arr[poll] +1;
                queue.add(x2);
            }
            if((x1 <= y && arr[x1] == Integer.MAX_VALUE)){
                arr[x1] = arr[poll]+1;
                queue.add(x1);
            }
            if((x3 <= y && arr[x3] == Integer.MAX_VALUE)){
                arr[x3] = arr[poll]+1;
                queue.add(x3);
            }


        }

        int answer = arr[y] == Integer.MAX_VALUE ? -1 : arr[y];
        return answer;
    }
}
