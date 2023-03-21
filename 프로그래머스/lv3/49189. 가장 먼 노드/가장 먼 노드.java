import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    // 그래프 생성을 위한 인접 리스트 선언
    public static ArrayList<Integer>[] list;
    // BFS 에서 방문 확인을 위한 boolean 배열 선언
    public static boolean[] visited;
    // BFS 에서 넓이 우선 탐색을 위한 Queue 선언
    public static Queue<Integer> q; 
    // 가장 멀리 떨어진 노드를 확인하기 위한 ArrayList 선언
    public static int[] len;
    
    public int solution(int n, int[][] edge) {
        // 초기화
        int answer = 0;
        visited = new boolean[n+1];
        q = new LinkedList<>();
        len = new int[n+1];
        list = new ArrayList[n+1];
        for (int i=0; i<=n; i++) list[i] = new ArrayList<>();
        
        // edge 2차원 배열의 값을 list 로 담는 과정
        for (int[] e : edge) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
		// // 그래프 출력
		// for (int i = 1; i <= n; i++) {
		// 	for(int j = 0 ; j < list[i].size();j++)
		// 		System.out.print(list[i].get(j)+" ");
		// 	System.out.println();
		// }
        
        BFS(1);
        
        // // 깊이 확인
        // for (int d : len) {
        //     System.out.print(d + " ");
        // }
        
        // 최대값 확인
        Arrays.sort(len);
        int max = len[n];
        
        // 개수 확인
        for (int i=0; i<=n; i++) {
            if (len[i] == max) answer++;
        }
        
        return answer;
    }
    
    public static void BFS (int start) {
        int tmp = 0;
        visited[start] = true;
        
        q.add(start);
        
        while (q.size() != 0) {
            tmp = q.poll();
            
            for (int node : list[tmp]) {
                if (visited[node]) continue;
                visited[node] = true;
                q.add(node);
                len[node] = len[tmp] + 1;
            }
        }
    }
}