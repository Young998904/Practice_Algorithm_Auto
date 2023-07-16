// /*
// 아이디어
// (1) 다익스트라를 사용, 이때 추가로 배열을 선언
// (2) 배열에 담기는 값은 그 곳에 가기위해 선택된 다리의 비용
// */

// import java.util.Queue;
// import java.util.PriorityQueue;
// import java.util.ArrayList;

// // Node 클래스 정의
// class Node implements Comparable<Node> {
//     int index;
//     int cost;
    
//     public Node (int index, int cost) {
//         this.index = index;
//         this.cost = cost;
//     }
    
//     @Override
//     public int compareTo (Node o) {
//         return Integer.compare(this.cost, o.cost);
//     }
// }

// class Solution {
//     public int solution(int n, int[][] costs) {
//         int answer = 0;
        
//         // 최소거리를 담을 배열
//         int[] minDist = new int[n];
//         // 최소비용을 담을 배열
//         int[] minCost = new int[n];
        
//         // 배열 초기화
//         int max = Integer.MAX_VALUE;
        
//         for (int i=0; i<n; i++) {
//             minDist[i] = max;
//         }
        
//         // 입력값 처리        
//         ArrayList<Node>[] graph = new ArrayList[n];
//         for (int i=0; i<n; i++) graph[i] = new ArrayList<>(); // 초기화
        
//         for(int[] c : costs) {
//             graph[c[0]].add(new Node(c[1], c[2]));
//             graph[c[1]].add(new Node(c[0], c[2]));
//         }
        
//         // 시작점 설정
//         Queue<Node> pq = new PriorityQueue<>();
//         boolean[] visited = new boolean[n];
        
//         minDist[0] = 0;
//         pq.add(new Node(0, 0));
        
//         // 탐색 시작
//         while(!pq.isEmpty()) {
//             int nowVertex = pq.poll().index;
            
//             if (visited[nowVertex]) continue;
//             visited[nowVertex] = true;
            
//             for (Node next : graph[nowVertex]) {
//                 if (minDist[next.index] > minDist[nowVertex] + next.cost) {
//                     // 최단 거리 값 갱신
//                     minDist[next.index] = minDist[nowVertex] + next.cost;
//                     // 최소 비용 값 갱신
//                     minCost[next.index] = next.cost;
//                     // Queue 삽입
//                     pq.offer(new Node(next.index, minDist[next.index]));
//                 }
//             }
//         }
        
//         // 값 계산
//         for (int i=1; i<n; i++) {
//             answer += minCost[i];
//             // System.out.printf("%d번째 : %d\n", i, minCost[i]);
//         }
        
//         return answer;
//     }
// }

// /*
// 아이디어
// (1) 다익스트라를 사용, 이때 추가로 배열을 선언
// (2) 배열에 담기는 값은 그 곳에 가기위해 선택된 다리의 비용

// -> 오류 : 출발 지점을 어떻게 하느냐에 따라 결과값이 달라짐
// => 다익스트라 부적합 => 모든 출발점을 확인하고 최소값인 경우를 출력한다.
// */

// import java.util.Queue;
// import java.util.PriorityQueue;
// import java.util.ArrayList;
// import java.util.Collections;

// // Node 클래스 정의
// class Node implements Comparable<Node> {
//     int index;
//     int cost;
    
//     public Node (int index, int cost) {
//         this.index = index;
//         this.cost = cost;
//     }
    
//     @Override
//     public int compareTo (Node o) {
//         return Integer.compare(this.cost, o.cost);
//     }
// }

// class Solution {
//     public int solution(int n, int[][] costs) {
//         int answer = 0;
        
//         // 최소거리를 담을 배열
//         int[][] minDist = new int[n][n];
//         // 최소비용을 담을 배열
//         int[][] minCost = new int[n][n];
//         // 정답값들을 담을 배열
//         ArrayList<Integer> answers = new ArrayList<>();
        
//         // 배열 초기화
//         int max = Integer.MAX_VALUE;
        
//        for (int[] dist : minDist) {
//            for (int i=0; i<n; i++) {
//                dist[i] = max;
//            }
//        }
        
//         // 입력값 처리        
//         ArrayList<Node>[] graph = new ArrayList[n];
//         for (int i=0; i<n; i++) graph[i] = new ArrayList<>(); // 초기화
        
//         for(int[] c : costs) {
//             graph[c[0]].add(new Node(c[1], c[2]));
//             graph[c[1]].add(new Node(c[0], c[2]));
//         }
        
//         // 시작점 설정
//         Queue<Node> pq = new PriorityQueue<>();
//         boolean[] visited = new boolean[n];
        
//         for (int start=0; start<n; start++) {
//             minDist [start][start] = 0;
//             pq.add(new Node(start, 0));
            
//             // 탐색 시작
//             while(!pq.isEmpty()) {
//                 int nowVertex = pq.poll().index;

//                 if (visited[nowVertex]) continue;
//                 visited[nowVertex] = true;

//                 for (Node next : graph[nowVertex]) {
//                     if (minDist[start][next.index] > minDist[start][nowVertex] + next.cost) {
//                         // 최단 거리 값 갱신
//                         minDist[start][next.index] = minDist[start][nowVertex] + next.cost;
//                         // 최소 비용 값 갱신
//                         minCost[start][next.index] = next.cost;
//                         // Queue 삽입
//                         pq.offer(new Node(next.index, minDist[start][next.index]));
//                     }
//                 }
//             }
            
//             // 값 계산
//             int sum = 0;
//             for (int i=0; i<n; i++) {
//                 sum += minCost[start][i];
//             }
//             answers.add(sum);
            
//             visited = new boolean[n];
//         }

//         return Collections.min(answers);
//  }
// }

/*
가장 큰 값 부터 하나씩 빼면서 연결 여부를 확인한다.
*/

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Node implements Comparable<Node> {
    public int start;
    public int end;
    public int cost;
    
    public Node (int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(o.cost, this.cost);
    }
}
class Solution {
    public static boolean[][] graph;
    public static boolean[] visited;
    public static int cnt = 1;
    public static boolean done = false;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        visited = new boolean[n];
        
        // (1) 입력값 담기
        Queue<Node> pq = new PriorityQueue<>();
        
        graph = new boolean[n][n];

        for (int[] cost : costs) {
            // 우선순위 큐에 Node 담기
            pq.offer(new Node(cost[0], cost[1], cost[2]));
            // 인접 행렬에 연결 반영
            graph[cost[0]][cost[1]] = true;
            graph[cost[1]][cost[0]] = true;
        }
        
        // // 우선순위 큐 입력확인
        // for (Node node : pq) {
        //     System.out.println(node.cost);
        // }
                
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            
            graph[node.start][node.end] = false;
            graph[node.end][node.start] = false;
            
            visited[0] = true;
            
            System.out.printf("%d 빼고 연결 가능 여부 : ", node.cost);
            if (isLinked(0, n)) {
                reset(n);
                System.out.println("가능");
                continue;
            }
            
            reset(n);
            System.out.println("불가능");
            
            graph[node.start][node.end] = true;
            graph[node.end][node.start] = true;

            answer += node.cost;
        }
        
        return answer;
    }
    
    public static boolean isLinked(int start, int n) {
        if (done) return true;
        
        for (int i=0; i<n; i++) {
            if (start == i || visited[i]) continue;
            
            if (graph[start][i]) {
                visited[i] = true;
                if (++cnt == n) done = true;
                isLinked(i, n);
            }
        }
        
        if (done) return true;
        
        return false;
    }
    
    public static void reset(int n) {
        cnt = 1;
        done = false;
        visited = new boolean[n];
    }
}