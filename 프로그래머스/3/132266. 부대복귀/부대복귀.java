/*
(1) 큐(PriorityQueue)
(2) 최소거리 int[] -> desti 

- 음가중치x (-> 1 거리 계산)
- 시작 정점이 하나 (sources -> destination) n -> 1 => (1 -> n)
*/

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // (1) 그래프 정보 담기
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        // (2) 탐색을 위해 필요한 배열 생성
        int[] len = new int[n+1]; // 최단 거리 담을 배열
        for (int i=0; i<=n; i++) {
            len[i] = Integer.MAX_VALUE; // 최댓값으로 초기화
        }
        
        // (3) 초기화 및 탐색 진행
        int nowVertex = destination;
        len[nowVertex] = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위큐 생성
        pq.add(nowVertex);
        
        while (!pq.isEmpty()) {
            nowVertex = pq.poll();
            
            // System.out.println(nowVertex);
            
            for (int next : graph[nowVertex]) {
                if (len[next] > len[nowVertex]+1) {
                    len[next] = len[nowVertex]+1; 
                    pq.add(next);
                }

            }
        }
        
        // for (int i : len) {
        //     System.out.printf("최단 거리 : %d\n", i);
        // }
        
        // (4) 정답 배열 생성 및 정답 처리
        int[] answer = new int[sources.length]; // 정답 담을 배열
        
        int idx = 0;
        for (int source : sources) {
            if (len[source] == Integer.MAX_VALUE) answer[idx] = -1;
            else answer[idx] = len[source];
            
            idx++;
        }
        
        return answer;
    }
}