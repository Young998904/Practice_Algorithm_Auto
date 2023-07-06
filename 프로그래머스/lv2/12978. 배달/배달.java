// // DFS
// class Solution {
//     // 거리를 담아두는 인접행렬
//     public static int[][] graph;
//     // 방문여부 확인
//     public static boolean[] visited;
//     // 최소 거리 값을 담아두는 배열
//     public static int[] minLen;
    
//     public int solution(int N, int[][] road, int K) {
//         // (1) 초기화
//         int answer = 1;
//         graph = new int[N+1][N+1];
//         visited = new boolean[N+1];
//         minLen = new int[N+1];
        
//         // (2) 행렬 값 담기
//         for (int[] r : road) {
//             // 기존 값보다 크면 continue;
//             if (graph[r[0]][r[1]] != 0 && graph[r[0]][r[1]] <= r[2]) continue;
//             // 아니면 값 담기
//             graph[r[0]][r[1]] = r[2];
//             graph[r[1]][r[0]] = r[2];
//         } // 그외 나머지 값들은 모두 0
        
//         // (3) DFS 수행
//         visited[1] = true;
//         DFS(1, 0, 0);
        
//         // (4) 최소값 확인 (정답 구하기)
//         for (int i=2; i<=N; i++) {
//             System.out.println(minLen[i]);
//             if (minLen[i] <= K) answer++;
//         }
        
//         return answer;
//     }
//     public static void DFS(int start, int depth, int len) {
//         if (depth == (minLen.length-1)) return;
        
//         for (int i=2; i<minLen.length; i++) {
//             if(visited[i] == true || graph[start][i] == 0) continue;
            
//             // 거리 더하기 & 방문처리
//             len += graph[start][i];
//             visited[i] = true;
//             // 거리 업데이트
//             update(i, len);
//             // 다음 DFS 수행
//             DFS(i, depth++, len);
            
//             // DFS 수행 후 원상 복귀
//             len -= graph[start][i];
//             visited[i] = false;
//         }
//     }
//     public static void update(int end, int len) { // 값을 갱신하는 함수
//         int tmp = minLen[end];
        
//         if (tmp == 0) {
//             minLen[end] = len;
//             return;
//         }
        
//         if (len > tmp) return;
        
//         minLen[end] = len;
//         return;
//     }
// }

// // 개선된 DFS
// class Solution {
//     // 거리를 담아두는 인접행렬
//     public static int[][] graph;
//     // 방문여부 확인
//     public static boolean[] visited;
//     // 최소 거리 값을 담아두는 배열
//     public static boolean[] find;
//     // 최소 거리
//     public static int k;
//     // 정답
//     public static int answer = 1;
    
//     public int solution(int N, int[][] road, int K) {
//         // (1) 초기화
//         graph = new int[N+1][N+1];
//         visited = new boolean[N+1];
//         find = new boolean[N+1];
//         k = K;
        
//         // (2) 행렬 값 담기
//         for (int[] r : road) {
//             // 기존 값보다 크면 continue;
//             if (graph[r[0]][r[1]] != 0 && graph[r[0]][r[1]] <= r[2]) continue;
//             // 아니면 값 담기
//             graph[r[0]][r[1]] = r[2];
//             graph[r[1]][r[0]] = r[2];
//         } // 그외 나머지 값들은 모두 0
        
//         // (3) DFS 수행
//         visited[1] = true;
//         DFS(1, 0, 0);
        
//         return answer;
//     }
//     public static void DFS(int start, int depth, int len) {
//         if (depth == (find.length-1)) return;
        
//         for (int i=2; i<find.length; i++) {
//             if(visited[i] == true || graph[start][i] == 0) continue;
            
//             // 거리 더하기 & 방문처리
//             len += graph[start][i];
//             visited[i] = true;
//             // 거리 업데이트
//             if (!find[i]) update(i, len);
//             // 다음 DFS 수행
//             DFS(i, depth++, len);
            
//             // DFS 수행 후 원상 복귀
//             visited[i] = false;
//             len -= graph[start][i];
//         }
//     }
//     public static void update(int end, int len) { // 값을 확인하는 함수
//         if (len > k) {
//             return;
//         }
        
//         answer++;
//         find[end] = true;
//     }
// }

// 다익스트라
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int index;
    int cost;
    
    public Node (int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost); 
        // 다른 표현 방법이 있는지 공부! (람다식에서 자주 활용됨!)
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        // 관련 변수 초기화
        int answer = 1; // 시작점은 무조건 가능
        boolean[] visited = new boolean[N+1]; // 방문여부
        int[] dist = new int[N+1]; // 최단 거리 기록
        int maxInt = Integer.MAX_VALUE;
        // for (int i=0; i<= N; i++) { // 초기화
        //     dist[i] = maxInt;
        // }
        // 대체 가능 코드
        Arrays.fill(dist, maxInt);
        Queue<Node> pq = new PriorityQueue<>(); // 우선순위 큐
        
        // 1. 입력값 정리
        // (1) 인접리스트 생성 및 초기화
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for (int i=0; i<=N; i++) graph[i] = new ArrayList<>();
    
        // (2) 값 정리
        for (int[] r : road) {
            graph[r[0]].add(new Node(r[1], r[2]));
            graph[r[1]].add(new Node(r[0], r[2]));
        }
        
        // // cf) 과정 1 확인
        // for(int i=1; i<=N; i++) {
        //     for (int j=0; j<graph[i].size(); j++) {
        //         System.out.printf("%d ", graph[i].get(j).index);
        //     }
        //     System.out.println();
        // }
        
        // 2. 다익스트라 수행
        // (1) 시작 전 초기화
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        
        // (2) 수행
        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;
            
            if (visited[nowVertex]) continue;
            visited[nowVertex] = true;
            
            // 인접 노드 탐색 & 값 생신
            for (Node next : graph[nowVertex]) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        
        // 3. 최소값 확인
        for (int i=2; i<=N; i++) {
            // System.out.printf("%d ", dist[i]);
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}