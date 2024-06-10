import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스킬트리 {

    public int solution(String skill, String[] trees) {
        int answer = 0;
        int[] arr = new int[26]; // skill의 순서 값 저장
        for(int i=0; i<skill.length(); i++){
            char c = skill.charAt(i);
            arr[c-'A'] = i+1;
        }

        for(int i =0; i<trees.length; i++) {
            int max = 0;
            boolean check = false;
            for(int j=0; j<trees[i].length(); j++){
                char c = trees[i].charAt(j);
                int value = arr[c - 'A'];
                if(value <= max || max + 1 == value){
                    max = Math.max(max, value);
                    continue;
                }
                check = true;
                break;
            }
            if(!check) answer++;
        }

        return answer;
    }
}
