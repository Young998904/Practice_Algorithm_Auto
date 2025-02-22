import java.util.*;

class Server {
    int time;
    
    public Server (int time) {
        this.time = time;
    }
}

// players 의 인덱스 범위 : 0-23
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] serverCnt = new int[24];
        
        // 서버 1개씩 기본 증설
        for (int i=0; i<24; i++) serverCnt[i] += serverCnt[i] + 1;
        
        // for (int v=0; v<24; v++) {
        //     System.out.printf("%d ", serverCnt[v]);
        // }
        // System.out.println();
        
        int need = 0;
        
        for (int i=0; i<24; i++) {            
            int player = players[i];
            
            // (1) 필요한 서버수 확인
            need = (int) player / m + 1;
            
            // System.out.printf("%d 구간에 필요한 서버 개수 : %d개\n", i, need);
            
            int add = need - serverCnt[i] > 0 ? need - serverCnt[i] : 0;
            
            // (2) 증설이 필요한 경우 : 서버 증설
            if (add > 0) {
                answer += add;
                
                // System.out.printf("%d 구간 : %d 개 증설\n", i, add);
            
                for (int j=i; j<i+k; j++) {
                    if (j > 23) break;
                    
                    serverCnt[j] += add;
                }            
                
                // for (int v=0; v<24; v++) {
                //     System.out.printf("%d ", serverCnt[v]);
                // }
                // System.out.println();
            }
            
        }
        
        return answer;
    }
}
/*
Server : time
현재 명수 : player
현재 서버수 : nowServer = Queue.Size
시간대별 서버 개수 : int[] serverCnt= new int[24]
사용 가능 시간 : k 시간
수용 명수 : m => m-1 명 (증설 x) / m 명 (증설 O)
필요한 서버의 개수 : (int) player / m + 1

*/