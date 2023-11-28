import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int ene = 0;
        for (int i=0; i<enemy.length; i++) {
            ene = enemy[i];
            
            if (n < ene && k==0) { // 종료 조건 : 더 이상 상대 불가능한 경우
                answer = i;
                break;
            }
            
            if (n >= ene) { // 상대 가능한 경우
                n -= ene;
                pq.add(ene);
                // System.out.printf("%d 라운드 무적권 없이 통과 / 남은 병사 %d명\n", i+1, n);
            }
            else { // 무적권 사용
                if (k == 0) break;
                k--;
                pq.add(ene);
                n -= ene;
                n += pq.poll();
                // System.out.printf("%d 라운드 무적권 사용하여 통과 / 남은 병사 %d명\n", i+1, n);
            }
            
            if (i == enemy.length-1) {
                answer = enemy.length;
            }
        }
        
        return answer;
    }
}