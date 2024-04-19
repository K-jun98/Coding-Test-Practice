import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TTest_2 {


    public int solution(int[][] relationships, int target, int limit) {
        List<ArrayList<Integer>> collect = IntStream.rangeClosed(0, 100).mapToObj(x -> new ArrayList<Integer>()).collect(Collectors.toList());
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] check = new boolean[101];
        int friend = 0;
        int newFriend = 0;

        for (int i = 0; i < relationships.length; i++) {
            int[] temp = relationships[i];
            int i1 = temp[1];
            int i2 = temp[0];
            if (i1 == target) {
                queue.add(new int[]{i2, 1});
                check[i2] = true;
                friend++;
            } else if (i2 == target) {
                check[i1] = true;
                queue.add(new int[]{i1, 1});
                friend++;
            }
            collect.get(i1).add(i2);
            collect.get(i2).add(i1);
        }

        check[target] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int index = poll[0];
            for (int i = 0; i < collect.get(index).size(); i++) {
                Integer i1 = collect.get(index).get(i);
                if (!check[i1] && poll[1] < limit) {
                    queue.add(new int[]{i1, poll[1] + 1});
                    check[i1] = true;
                    newFriend++;
                }
            }
        }

        int answer = friend * 5 + newFriend * 10;
        System.out.println(answer + newFriend);
        return answer + newFriend;
    }

    public static void main(String[] args) {
        TTest_2 toss = new TTest_2();
        toss.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 2, 3);
        toss.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 1, 2);
    }
}
