import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 우선 순위 큐를 활용한 minHeap 선언
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 원소 추가
        for (int i=0; i<scoville.length; i++) {
            minHeap.add(scoville[i]);
        }
        
        while (minHeap.peek() < K && minHeap.size() != 1) {
            int top = minHeap.poll();
            int next = minHeap.poll();
            
            minHeap.add(top + 2*next);
            answer++;
        }
        
        if (minHeap.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}
/*
① 기본 자료구조 : (우선순위 큐) 최소힙
②
*/