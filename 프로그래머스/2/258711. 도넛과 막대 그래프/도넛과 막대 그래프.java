import java.util.*;

class Solution {
    static final int MAX = 1000000;
    static int[][] edges;
    static int[] input, output;
    
    public int[] solution (int[][] edges) {
        this.edges = edges;
        input = new int[MAX+1];
        output = new int[MAX+1];
        
        int maxNode = 0;
        
        for(int[] e : edges) {
            output[e[0]]++;
            input[e[1]]++;
            // 가장 큰 값의 노드 탐색
            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }
        
        int[] answer = new int[4];
        
        for(int i=1 ; i <= maxNode; i++) {
             // 진입 0 / 진출 2 이상 => 생성점
            if(input[i] == 0 && output [i] >= 2) {answer[0] = i;}
            // 진입 1개 이상 / 진출 0 => 막대 그래프 종점 => 막대 그래프++
            else if(input[i] > 0 && output[i] == 0) {answer[2]++;}
            // 집입 2개 이상 / 진출 2개 이상 => 8자 그래프 중심점 => 8자 그래프++
            else if(input[i] >= 2 & output [i] >= 2) {answer[3]++;}
        }
        
        // 도넛 그래프 수 = 생성점의 진출 수 - (막대 그래프 + 8자 그래프)
        answer[1] = output[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
}
    
// import java.util.*;

// class Solution {
//     public int[] solution(int[][] edges) {
//         int[] answer = {};
        
//         // (1) 입력 정리
//         int max = 0;
//         Map<Integer, Queue<Integer>> map = new HashMap<>();
        
//         for (int[] edge : edges) {
//             max = edge[0] > max ? edge[0] : max;
//             max = edge[1] > max ? edge[1] : max;
            
//             // map.put(edge[0], map.getOrDefault(edge[0], new LinkedList<Integer>()).offer(edge[1]));
            
//             map.putIfAbsent(edge[0], new LinkedList<Integer>());
//             map.get(edge[0]).add(edge[1]);
//         }
        
//         System.out.println(max);
        
//         Set<Integer> keySet = map.keySet();
        
//         for (int key : keySet) {
//             System.out.printf("시작점 : %d\n",key);
            
//             Queue<Integer> q = map.get(key);
            
//             while (!q.isEmpty()) {
//                 System.out.printf("%d ", q.poll());
//             }
//             System.out.println();
//         }
        
//         return answer;
//     }
// }