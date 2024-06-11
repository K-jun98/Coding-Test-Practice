import java.util.Arrays;

public class 파일명정렬 {

    public static void main(String[] args) {
        파일명정렬 t = new 파일명정렬();
        String[] solution = t.solution(new String[]{"mu zi11112222.png","MU zi11112222.zip","mu zi11112122.png"});
        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            int[] s1Arr = getIndex(s1);
            int[] s2Arr = getIndex(s2);
            String s1Head = s1.substring(0, s1Arr[0]).toUpperCase();
            String s2Head = s2.substring(0, s2Arr[0]).toUpperCase();

//            System.out.println("s1Head = " + s1Head);
//            System.out.println("s2Head = " + s2Head);
            if (s1Head.equals(s2Head)) {
                int s1Int = Integer.valueOf(s1.substring(s1Arr[0], s1Arr[1]));
                int s2Int = Integer.valueOf(s2.substring(s2Arr[0], s2Arr[1]));

//                System.out.println("s1Int = " + s1Int + "s2Int = " + s2Int);
                if (s1Int == s2Int) {
                    return 0;
                }
                return s1Int - s2Int;
            }
            return s1Head.compareTo(s2Head);
        });
        return files;
    }

    public int[] getIndex(String str) {
        int[] arr = new int[]{0, str.length()};
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                arr[0] = i;
                break;
            }
        }

        for (int i = arr[0]; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c >= '0') || !(c <= '9')) {
                arr[1] = i;
                break;
            }
        }
        arr[1] = arr[1] > arr[0] + 5 ? arr[0] + 5 : arr[1];
        return arr;
    }
}
