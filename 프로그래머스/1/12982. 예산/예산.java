import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int minIdx = 0;
        
        int rq = 0;
        
        for(int i=0; i<d.length; i++) {
            Arrays.sort(d);
            
            rq = d[minIdx];
            d[minIdx] = 0;
            
            if (budget - rq >= 0) {
                budget -= rq;
                minIdx++;
                answer++;
            }
            else break;
        }
        return answer;
    }
}