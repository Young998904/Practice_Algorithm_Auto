import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;

// Room 클래스 선언
class Room implements Comparable<Room> {
    int startTime;
    int endTime;
    
    public Room (int sh, int sm, int eh, int em) {
        this.startTime = sh*60 + sm;
        this.endTime = eh*60 + em + 10; // 먼저 청소시간 10분을 더한다.
    }
    
    @Override
    public int compareTo (Room other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}
class Solution {
    public static ArrayList<Room> roomList;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        int roomCnt = 0;

        // 입력값 정리
        String[] start, end;
        Queue<Room> pq = new PriorityQueue<>();
        
        for (String[] times : book_time) {
            start = times[0].split(":");
            end = times[1].split(":");
            
            pq.add(new Room(Integer.parseInt(start[0]), Integer.parseInt(start[1]), 
                            Integer.parseInt(end[0]), Integer.parseInt(end[1])));
        }
        
        // Queue 들을 담을 ArrayList 선언 & 초기값 처리
        roomList = new ArrayList<>();
        
        roomList.add(pq.poll());
        
        System.out.println(roomList.size());
        
        // Queue 처리
        while(!pq.isEmpty()) {
            Room room = pq.poll();
            int[] roomInfo = minEndTime();
            
            // 경우 (1) : 새로운 방의 시작 시간이 나머지 방들의 종료시간 보다 늦은 경우
            if (room.startTime < roomInfo[0]) {
                // 방을 추가하여 넣음
                roomList.add(room);
                // System.out.println(roomList.size());
            }
            // 경우 (2) : 새로운 방의 시작 시간이 나머지 방들이 종료시간 보다 빠른 경우
            else {
                // 최소 종료 시간 방에 해당 방을 넣는다.
                roomList.set(roomInfo[1], room);
            }
        }
        
        // 총 원소의 개수 = 필요한 방의 개수
        return roomList.size();
    }
    public int[] minEndTime () {
        int[] info = {Integer.MAX_VALUE, 0};
        
        for (int i=0; i<roomList.size(); i++) {
            if (roomList.get(i).endTime < info[0]) {
                info[0] = roomList.get(i).endTime;
                info[1] = i;            
            }
        }
        
        // System.out.printf("최소값 : %d, 최소 인덱스 : %d \n", info[0], info[1]);
        return info;
    }
}