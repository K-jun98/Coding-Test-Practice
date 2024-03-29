import java.util.ArrayList;
import java.util.List;

public class 무인도여행 {
    int[] yArr = new int[]{-1,0,1,0};
    int[] xArr = new int[]{0,-1,0,1};
    String[][] arr = new String[0][0];
    int count =0;

    public int[] solution(String[] maps) {
        int[] answer = {-1};
        arr = new String[maps.length][maps[0].length()]; // 2차 배열로 변경한 배열
        List<Integer> list = new ArrayList(); // 식량의 총 합을 담을 리스트

        for(int i =0; i<arr.length; i++){
            arr[i]= maps[i].split("");
        }

        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(!arr[i][j].equals("X")){
                    count = 0;
                    count+= Integer.parseInt(arr[i][j]);
                    arr[i][j]="X";
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        //System.out.println(Arrays.deepToString(arr));
        //list.forEach(System.out::println);
        if(list.isEmpty()){
            return answer;
        }
        return list.stream().mapToInt(Integer::valueOf).sorted().toArray();
    }

    public void dfs(int y, int x){

        for(int i=0; i<4; i++){
            int dy = y + yArr[i];
            int dx = x + xArr[i];
            if(dy>=0 && dy<arr.length && dx >= 0 && dx<arr[0].length && !arr[dy][dx].equals("X")){
                count+= Integer.parseInt(arr[dy][dx]);
                arr[dy][dx]="X";
                dfs(dy,dx);
            }
        }
    }
}
