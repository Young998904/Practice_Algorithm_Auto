class Solution {
    public static boolean[][] graph;
    public static boolean[] visited;
    public static int N;
    public static int cnt = 1;
    
    public int solution(int n, int[][] wires) {
        N = n;
        
        // visited 배열 생성
        visited = new boolean[n+1];
        
        // graph 인정행렬 생성
        int size = wires.length;
        
        graph = new boolean[n+1][n+1];
        
        // 입력값 정리
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        
        // 탐색
        int now = 0;
        int[] countTops = new int[size];
        
        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = false;
            graph[wire[1]][wire[0]] = false;
            
            // 연결 끊은 후 연결된 송전탑의 개수 확인
            visited[wire[0]] = true;
            countTop(wire[0]);
            countTops[now++] = Math.abs(n - 2 * cnt);
            
            cnt = 1;
            visited = new boolean[n+1];
            
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        
        // 최소 차이 구하기
        int answer = n-2;
        
        for (int cnt : countTops) {
            if (cnt < answer) answer = cnt;
        }
        
        return answer;
    }
    
    public static void countTop(int start) { // DFS
        for (int i=1; i<=N; i++) {
            if (start == i || visited[i] || !graph[start][i]) continue;
            cnt++;
            visited[i] = true;
            countTop(i);
        }
    }
}