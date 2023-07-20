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
        return Integer.compare(o.cost, this.cost); // 내림차순
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
            
        // (2) Greedy 적용하면서 전체 탐색
        while (!pq.isEmpty()) {
            Node node = pq.poll(); // 가장 비용이 큰 노드 [2,3,8]
            
            // 연결 끊기
            graph[node.start][node.end] = false;
            graph[node.end][node.start] = false;
            
            // 연결 가능 탐색
            visited[0] = true;
            
            if (isLinked(0, n)) { // 경우 1 : 연결 가능하면 없어도 가능하므로 answer 에 값 추가 안함
                reset(n);
                continue;
            }
            
            // 경우2 : 연결 불가능하면 필요한 값이므로 answer 에 값 추가
            reset(n);
            
            // 연결 원상복구
            graph[node.start][node.end] = true;
            graph[node.end][node.start] = true;

            answer += node.cost;
        }
        
        return answer;
    }
    
    // 연결 탐색 : DFS
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
    
    // 연결 탐색 후 초기화
    public static void reset(int n) {
        cnt = 1;
        done = false;
        visited = new boolean[n];
    }
}