import java.util.Queue;
import java.util.LinkedList;

// class truck {
//     int w;
//     int t;
    
//     public truck (int weight) {
//         w = weight;
//         t = 0;
//     }
// }

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 현재 시간
        int tw = 0; // 다리 위의 총 무게
        int index = 0; // 지나가야하는 다음 index
        Queue<Integer> bridge = new LinkedList<>(); // 다리
        Queue<Integer> stop = new LinkedList<>(); // 분기

        while (index < truck_weights.length) {// 다 넣을 때 까지
            if (!stop.isEmpty() && time == stop.peek()) {
                // 무게 빼고 & 큐에서 빼고 동시
                tw -= bridge.poll();
                stop.remove();
            }
            // (1) 더 넣을 수 있는 상태면
            // 넣고, 무게추가, 종료시간 추가
            if (bridge.size() < bridge_length && tw + truck_weights[index] <=  weight) {
                tw += truck_weights[index]; // 무게 추가
                bridge.add(truck_weights[index]); // 다리에 넣기
                stop.add(time + bridge_length); // 시간 분기점 추가
                time++; // 시간 흐름
                index++; // 다음 배열
                continue;
            }
            // (2) 더 넣을 수 없는 상태면 그대로 시간추가 +1
            time ++;
        }

        while (!stop.isEmpty()) {
            time = stop.poll();
        }
        return time+1;
    }
}
/*
1. 필요한 변수
(1) int time : 현재 시간 (= answer)
(2) int tw(=total weigth) : 다리 위 총 무게
(3) Queue q : 다리 에 올라가있는 트럭들의 나열 (동시 대수 제한을 위해)
(4) int index : truck_weights 배열의 인덱스 탐색

2. 시간이 지나는 과정
(1) 동시간 동안 올라가있는 트럭의 개수와 무게를 고려해야함
-> Queue 의 size 와 total 의 값 비교
(2) 한 트럭이 지나는데 걸리는 시간은?
가) bridge_length 초

3. 반복문 조건
가) for 문 사용해서 배열 전체 탐색 -> 불편할듯
나) while 문 사용해서 배열의 마지막 index 까지 갈때

추가생각)
현재시간과 멈출시간
멈추는 시간을 알아햐한다 == 빼는 시간
-> 넣을 때 +다리길이 // 그런데 이시간도 stack으로 구해야한다
*/