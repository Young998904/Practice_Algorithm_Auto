
/*
크루스칼 알고리즘
*/

import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node> { // 노드 클래스 선언
    int indexA, indexB, cost;
    
    public Node (int indexA, int indexB, int cost) {
        this.indexA = indexA;
        this.indexB = indexB;
        this.cost = cost;
    }
    
    @Override
    public int compareTo (Node other) {
        if (this.cost < other.cost) return -1;
        return 1;
    }
}

class Solution {
    // root 노드 값을 담는 배열
    public static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // parent 배열 초기화
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        // 입력값 처리
        ArrayList<Node> vertexList = new ArrayList<>();
        for (int[] cost : costs) {
            vertexList.add(new Node(cost[0], cost[1], cost[2]));
        }
        // 정렬
        Collections.sort(vertexList);
        
        for (int i=0; i<vertexList.size(); i++) {
            int from = vertexList.get(i).indexA;
            int to = vertexList.get(i).indexB;
            int cost = vertexList.get(i).cost;
            // 루트 원소가 같지 않다면 사이클이 발생하지 않는 것이므로 묶음처리
            if (findParent(from) != findParent(to)) {
                union(from, to);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    public static int findParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }
    
    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}