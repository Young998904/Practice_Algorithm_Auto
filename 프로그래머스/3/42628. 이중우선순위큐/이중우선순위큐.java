import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
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
                    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                    maxHeap.addAll(minHeap);
                    int max = maxHeap.poll();
                    
                    minHeap.remove(max);
                }
            }
        }
        
        if(minHeap.isEmpty()) {
            return new int[] {0,0};
        }
        else if (minHeap.size() == 1) {
            int num = minHeap.poll();
            return new int[] {num, num};
        }
        else {
            int min = minHeap.poll();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            maxHeap.addAll(minHeap);
            int max = maxHeap.poll();
            return new int[] {max, min};
        }
    }
}