import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 오픈채팅방 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

    }

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap(); // id, 최종 닉네임
        String[][] strs = new String[record.length][3]; //0 -> 명령어 , 1 -> id, 2 -> 닉네임

        for(int i =0; i<record.length; i++){
            strs[i] = record[i].split(" ");
            //System.out.println(Arrays.toString(splits));
            if(strs[i].length > 2){
                map.put(strs[i][1], strs[i][2]);
            }
        }

        List<String> list = new ArrayList();
        for(int i =0; i<strs.length; i++){
            String doo = strs[i][0];

            if(doo.equals("Enter")){
                list.add(map.get(strs[i][1])+"님이 들어왔습니다.");
            }else if(doo.equals("Leave")){
                list.add(map.get(strs[i][1])+"님이 나갔습니다.");
            }
        }

        String[] answer = list.toArray(new String[0]);
        return answer;
    }
}
