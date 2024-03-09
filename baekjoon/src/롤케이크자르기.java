import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 롤케이크자르기 {

    public int solution(int[] topping) {
        int[] arr = new int[10_001];
        int[] larr = new int[10_001];
        int answer =0;
        int count = 0;
        for(int i =0; i<topping.length; i++){
            int v = topping[i];
            if ( arr[v] == 0) count ++;
            arr[v]++;
        }



        int lCount = 0;
        for(int i=0; i<topping.length; i++){
            int v = topping[i];
            arr[v]--;
            larr[v]++;
            if(arr[v] == 0) count--;
            if(larr[v] == 1) lCount ++;

            if(count == lCount){
                answer++;
            }
        }
        return answer;
    }
}
