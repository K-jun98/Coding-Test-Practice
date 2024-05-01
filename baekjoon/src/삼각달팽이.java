import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 삼각달팽이 {
    int[] yArr = new int[]{1,0,-1};
    int[] xArr = new int[]{0,1,-1};
    private List<String> collect;

    public int[] solution(int n) {
        int start = 1;
        int dir = 0;
        int y=0;
        int x=0;
        int[][] arr = new int[n][n];
        arr[0][0] = start++;
        boolean check = false;
        while(true){
            // System.out.println("dir = " + dir);
            int dy = y + yArr[dir];
            int dx = x + xArr[dir];

            if(dy>=0 && dy < n && dx>=0 && dx<n && arr[dy][dx] == 0){
                arr[dy][dx] = start++;
                check = false;
                y = dy;
                x = dx;
            } else {
                dir = (dir+1)%3;
                if(check){
                    break;
                }
                check = true;
            }
        }

        List<Integer> list = new ArrayList();
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(arr[i][j]!=0){
                    list.add(arr[i][j]);
                }else{
                    break;
                }
            }
        }

        int[] array = list.stream().mapToInt(Integer::valueOf).toArray();
        // System.out.println(Arrays.deepToString(arr));


        List<String> words = Arrays.asList("Hello", "World");

        // 각 문자열을 문자의 스트림으로 변환 후 모두 합쳐서 하나의 스트림으로 만듦
        List<String> uniqueCharacters = collect;
        return array;
    }
}

