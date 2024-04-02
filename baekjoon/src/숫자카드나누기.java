import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 숫자카드나누기 {
    boolean check = false;
    List<Integer> values = new ArrayList();
    List<Integer> answers = new ArrayList();
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        find(arrayA,arrayB);
        find(arrayB,arrayA);


        return answers.get(0) > answers.get(1) ? answers.get(0) : answers.get(1);
    }


    public void find(int[] arrayA, int[] arrayB){
        int max = arrayA[arrayA.length-1];
        int start =2;

        for(int i = start; i<=max; i++ ){
            addValue(i,arrayA);
        }

        for(int i=values.size()-1; i>=0; i-- ){
            int v = values.get(i);

            if(check(v, arrayB)){
                answers.add(v);
                return;
            }
        }
        answers.add(0);
    }


    public boolean check(int value, int[] array) {
        for(int j =0; j<array.length; j++){
            if(array[j] % value == 0){
                return false;
            }
        }
        return true;
    }

    public void addValue(int value, int[] array) {
        for(int v : array){
            if(v%value != 0) {
                check = false;
                return;
            }
        }
        values.add(value);
        return;
    }
}
