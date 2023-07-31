import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

class Info {
    int time;
    boolean in;
    
    public Info (String timeStr, String in) {
        String[] times = timeStr.split(":");
        this.time = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
        
        // System.out.printf("%d \n", this.time);
        
        if (in.equals("IN")) {
            this.in = true;
        }
        else {
            this.in = false;
        }
        // System.out.printf("%b \n", this.in);
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // (1) records 배열 입력값 정리
        HashMap<String, Queue<Info>> recordMap = new HashMap<>();
        
        for (String str : records) {
            String[] record = str.split(" ");
            
            String carNum = record[1];
            
            Queue<Info> queue;
            
            if (recordMap.containsKey(carNum)) {
                queue = recordMap.get(carNum);
            }
            else {
                queue = new LinkedList<Info>();
                recordMap.put(carNum, queue);
            }
            
            // System.out.printf("%s, %s, %s \n", record[0], record[1], record[2]);
            
            Info newInfo = new Info(record[0], record[2]);
            
            // System.out.printf("time : %d, in : %b \n", newInfo.time, newInfo.in);
            
            queue.offer(newInfo);
            
            recordMap.put(carNum, queue);
        }
        
        // (2) result 크기 확인 및 배열 생성
        int[] answer = new int[recordMap.size()];
        // System.out.printf("배열의 크기 : %d \n", recordMap.size());
        
        // (3) HashMap 전체 탐색하며 요금정리
        Iterator<Map.Entry<String, Queue<Info>>> entry = recordMap.entrySet().iterator();
        HashMap<String, Integer> timeMap = new HashMap<>();
        
        int maxTime = 23*60 + 59;
        int fare = 0;
        int timeGap = 0;

        while (entry.hasNext()) {
            Map.Entry<String, Queue<Info>> element = entry.next();
            Queue<Info> q = element.getValue();
            
            while (!q.isEmpty()) {
                Info infoStart = q.poll();
                Info infoEnd = q.poll();
                
                // 시간 차이 계산
                if (infoEnd == null) {
                    timeGap = maxTime - infoStart.time;
                }
                else {
                    timeGap = infoEnd.time - infoStart.time;
                }
                
                // 시간 저장 (갱신)
                if (!timeMap.containsKey(element.getKey())) {
                    timeMap.put(element.getKey(), timeGap);
                    continue;
                }
                timeMap.put(element.getKey(), timeMap.get(element.getKey())+timeGap);
            }
        }
        
        // (4) 정렬 후 배열 반환
        ArrayList<String> carNums = new ArrayList<>(recordMap.keySet());
        Collections.sort(carNums);
        
        int idx = 0;
        for (String carNum : carNums) {
            int totalTime = timeMap.get(carNum);
            // 요금 계산
            // System.out.printf("누적 주차 시간 : %d \n", totalTime);
            if (totalTime <= fees[0]) {
                fare = fees[1];
            }
            else {
                fare = fees[1] + ((int)Math.ceil(((double)totalTime-fees[0])/fees[2])) * fees[3];
            }
            
            // System.out.printf("주차요금 : %d \n", fare);
            
            answer[idx++] = fare;
        }
        
        return answer;
    }
}
/*
(1) record 배열을 전체 탐색하며 HashMap<String, Queue> 에 정보들을 담음
(2) HashMap 을 통해 result 배열의 크기 확인
(3) HashMap 을 전체 탐색하며 시간 정리
(4) HashMap KeySet 정렬 후 요금 계산 후 배열에 담음

참고
(1) HashMap<String, Queue> 구조
https://stackoverflow.com/questions/19473948/map-with-a-queue
(2) HashMap + Queue = LinkedHashMap
https://stackoverflow.com/questions/11107433/is-it-possible-to-create-a-queue-for-hashmap-set
(3) HashMap 순회
https://developer-talk.tistory.com/520
*/