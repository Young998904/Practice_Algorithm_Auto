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
        
        // 반복문 조건 (1) : 최소값을 가진 원소가 K 값보다 작다.
        // 반복문 조건 (2) : Heap 의 원소가 1개 밖에 없다.
        while (minHeap.peek() < K && minHeap.size() != 1) {
            int top = minHeap.poll();
            int next = minHeap.poll();
            
            minHeap.add(top + 2*next);
            answer++;
        }
        
        // 반복문을 다 돌았는데도 최소 노드 값이 K 보다 작다면 만들 수 없는 경우 의미
        if (minHeap.peek() < K) {
            return -1;
        }
        
        return answer;
    }
}
/*
기본 자료구조 : (우선순위 큐) 최소힙
*/