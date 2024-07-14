/*
1. 레드-블랙 트리 => TreeSet => 앞 뒤로 / 정렬 -> Set (중복값X)
2. Dequeue => 앞 뒤로 / 중복값 -> 정렬X
3. PriorityQueue 2개 => Heap 자료구조 (이진 트리 -> 배열)
*/

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름 차순
        
        for (String oper : operations) {
            String[] op = oper.split(" ");
            
            if (op[0].equals("I")) { // (1) 삽입 명령어
                minHeap.add(Integer.parseInt(op[1]));
            }
            else { // (2) 삭제 명령어
                if (minHeap.isEmpty()) continue; // 삭제 할 것이 없다면 건너 뛴다
                
                if (op[1].equals("-1")) { // (2)-1 최소값 삭제
                    minHeap.poll();
                }
                else { // (2)-2 최댓값 삭제
                    // 내림차순
                    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                    maxHeap.addAll(minHeap);
                    int max = maxHeap.poll();
                    
                    minHeap.remove(max); // 동기화
                }
            }
        }
        
        if(minHeap.isEmpty()) { // 비어있는 경우
            return new int[] {0,0};
        }
        else if (minHeap.size() == 1) { // 사이즈 1
            int num = minHeap.poll();
            return new int[] {num, num};
        }
        else { // 나머지 경우
            int min = minHeap.poll();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            maxHeap.addAll(minHeap);
            int max = maxHeap.poll();
            return new int[] {max, min};
        }
    }
}