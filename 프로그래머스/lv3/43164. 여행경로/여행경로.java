// import java.util.HashMap;
// import java.util.PriorityQueue;

// class Solution {
//     public String[] solution(String[][] tickets) {
//         int N = tickets.length;
//         String[] answer = new String[N+1];
        
//         // 입력 처리
//         HashMap<String, PriorityQueue<String>> ticketMap = new HashMap<>();
//         String start = "";
//         String end = "";
        
//         PriorityQueue<String> pq;
        
//         for (String[] ticket : tickets) {
//             start = ticket[0];
//             end = ticket[1];
            
//             if (ticketMap.containsKey(start)) {
//                 pq = ticketMap.get(start);
//             }
//             else {
//                 pq = new PriorityQueue<String>();
//                 ticketMap.put(start, pq);
//             }
            
//             pq.add(end);
//             ticketMap.put(start, pq);
//         }
        
//         // 탐색
//         start = "ICN";
//         answer[0] = start;
//         int cnt = 1;
        
//         while (cnt < N+1) {
//             start = ticketMap.get(start).poll(); 
//             answer[cnt++] = start;
//         }
        
//         return answer;
//     }
// }

// // 알파벳이 빠르다고 무조건 먼저 소진하면 전체를 다 돌 수 없다.
// // DFS

// import java.util.HashMap;
// import java.util.PriorityQueue;

// class Solution {
//     // 변수 선언
//     public static HashMap<String, PriorityQueue<String>> ticketMap;
//     public static int N;
//     public static int cnt = 0;
//     public static String[] answer;
//     public static boolean stop = false;
    
//     public String[] solution(String[][] tickets) {
//         // 초기화
//         N = tickets.length;
//         answer = new String[N+1];
        
//         // 입력처리
//         ticketMap = new HashMap<>();
//         String start = "";
//         String end = "";
        
//         PriorityQueue<String> pq;
        
//         for (String[] ticket : tickets) {
//             start = ticket[0];
//             end = ticket[1];
            
//             if (ticketMap.containsKey(start)) {
//                 pq = ticketMap.get(start);
//             }
//             else {
//                 pq = new PriorityQueue<String>();
//                 ticketMap.put(start, pq);
//             }
            
//             pq.add(end);
//             ticketMap.put(start, pq);
//         }
        
//         // 탐색
//         answer[cnt++] = "ICN"; // cnt = 1
//         DFS("ICN");
        
//         return answer;
//     }
    
//     public static void DFS(String start) {
//         if (cnt == N) { // 종료 조건
//             answer[cnt] = ticketMap.get(start).poll();
//             stop = true;
//             return;
//         }
        
//         int size = ticketMap.get(start).size();
//         // 경우(1) : 다음 경로 설정이 불가능한 경우 -> 재귀 종료
//         if (size == 0) {
//             return;
//         }
        
//         for (int i=1; i<=size; i++) {
//             // 경우(2)  :다음 경로 설정이 가능한 경우 -> 정답에 추가한 뒤 DFS 재귀 호출
//             String end = ticketMap.get(start).poll();
//             answer[cnt++] = end;
        
//             // DFS 재귀
//             DFS(end);

//             if (stop) return; // 정답을 찾은 경우

//             // 복구
//             cnt--;
//             PriorityQueue pq = ticketMap.get(start);
//             pq.add(end);

//             ticketMap.put(start, pq);
//         }
//     }
// }

// // PriorityQueue 로 만드는것은 재귀 돌 때 한계가 있음 -> ArrayList 와 visited 부분 필요

// import java.util.HashMap;
// import java.util.ArrayList;
// import java.util.Collections;

// class Contry implements Comparable<Contry> {
//     String contry;
//     boolean visited;
    
//     public Contry (String contry) {
//         this.contry = contry;
//         visited = false;
//     }
    
//     @Override
//     public int compareTo(Contry other) {
//         return this.contry.compareToIgnoreCase(other.contry);
//     }
// }

// class Solution {
//     public static HashMap<String, ArrayList<Contry>> ticketMap;
    
//     public String[] solution(String[][] tickets) {
//         int N = tickets.length;
//         String[] answer = new String[N+1];
        
//         // 입력값 처리
//         String start = "";
//         String end = "";
        
//         for (String[] ticket : tickets) {
//             start = ticket[0];
//             end = ticket[1];
            
//             ArrayList<Contry> arrList;
            
//             if (ticketMap.containsKey(start)) {
//                 arrList = ticketMap.get(start);
//             }
//             else {
//                 arrList = new ArrayList<Contry>();
//             }
            
//             arrList.add(new Contry(end)); 
//             Collections.sort(arrList);
//             ticketMap.put(start, arrList);
//         }
        
//         // String str = "ICN";
//         // System.out.println(str.compareTo("IAD"));
        
//         return answer;
//     }
// }

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Contry implements Comparable<Contry> {
    String end;
    boolean visited;
    
    public Contry (String end) {
        this.end = end;
        visited = false;
    }
    
    @Override
    public int compareTo(Contry other) {
        return this.end.compareToIgnoreCase(other.end);
    }
}

class Solution {
    public static String[] answer;
    public static HashMap<String, ArrayList<Contry>> ticketMap = new HashMap<>();
    public static int depth = 0;
    public static int n;
    public static boolean stop = false;
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        answer = new String[n+1];
        
        // 입력값 처리
        String start;
        String end;
        for (String[] ticket : tickets) {
            start = ticket[0];
            end = ticket[1];
            
            if (!ticketMap.containsKey(start)) {
                ticketMap.put(start, new ArrayList<Contry>());
            }
            
            ticketMap.get(start).add(new Contry(end));
            Collections.sort(ticketMap.get(start));
        }
        
//         ArrayList<Contry> arr = ticketMap.get("ICN");
        
//         for (Contry contry : arr) {
//             System.out.println(contry.end);
//         }
        
        // DFS 수행
        answer[depth++] = "ICN";
        dfs("ICN");
        return answer;
    }
    public static void dfs(String start) {
        if (depth == n+1) { // 마지막 지점까지 오면 종료
            stop =true;
            return;
        }
        if (!ticketMap.containsKey(start)) return;
        
        ArrayList<Contry> arrList = ticketMap.get(start);
        
        for (Contry contry : arrList) {
            if (contry.visited) continue;
            
            contry.visited = true;
            answer[depth++] = contry.end;
            dfs(contry.end);
            if (stop) return;
            depth--;
            contry.visited = false;
        }
    }
}