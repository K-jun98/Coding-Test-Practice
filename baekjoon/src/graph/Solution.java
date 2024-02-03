package graph;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int[] picks2;
    boolean[] picks3;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution();
    }

    public int solution() {
        int[] arr = new int[]{1, 2, 3, 4};
        picks2 = arr;
        picks3 = new boolean[arr.length];

        print();


        int answer = 0;
        return answer;
    }

    public void print() {
        if (list.size() == picks2.length) {
            list.forEach(x -> System.out.printf(x.toString()));
            System.out.println();
            return;
        }
        for (int i = 0; i < picks2.length; i++) {
            if (!picks3[i]) {
                list.add(picks2[i]);
                picks3[i] = true;
                print();
                list.remove(list.size() - 1);
                picks3[i] = false;
            }
        }
    }
}
