import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 호텔대실 {

    public static void main(String[] args) {
        호텔대실 hotel = new 호텔대실();
        int solution = hotel.solution(new String[][]{
                {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}
        });
        System.out.println(solution);
    }

    public int solution(String[][] book_time) {
        // 예약 시간을 분 단위로 변환하고 시작 시간과 종료 시간 + 청소 시간을 고려하여 배열에 저장
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]); // 시작 시간
            times[i][1] = toMinutes(book_time[i][1]) + 10; // 종료 시간 + 10분 청소 시간
        }

        List<Integer[]> list = new ArrayList<>();

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        list.add(new Integer[]{times[0][0], times[0][1]});

        // 시작 시간을 기준으로 예약 시간 정렬

        for (int i = 1; i < times.length; i++) {
            int start = times[i][0];

            int index = -1;
            int time = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                int temp = start - list.get(j)[1];
                if (temp >= 0 && time > temp){
                    time = temp;
                    index = j;
                }
            }

            if (index != -1) {
                list.set(index, new Integer[]{start, times[i][1]});
            } else {
                list.add(new Integer[]{start, times[i][1]});
            }
        }

        // 큐의 크기가 필요한 최소 객실 수
        return list.size();
    }

    // HH:MM 형태의 시간을 분으로 변환
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
