import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        List<Integer> bridge = new ArrayList();
        for(int i = 0; i<bridge_length; i++) {
            bridge.add(0);
        }

        Queue<Integer> queue = new ArrayDeque();
        for(int i = 0; i<truck_weights.length; i++){
            queue.add(truck_weights[i]);
        }
        int curW = 0;
        int answer = 0;
        while(!queue.isEmpty()){
            int peek = queue.peek();
            int head = bridge.get(0);
            if(curW + peek - head <= weight) {
                curW -= bridge.remove(0);
                curW += peek;
                bridge.add(queue.poll());
                answer++;
            }else{
                curW -= bridge.remove(0);
                bridge.add(0);
                answer++;
            }
        }

        while(curW != 0 ){
            curW -= bridge.remove(0);
            answer++;
        }

        return answer;
    }
}
