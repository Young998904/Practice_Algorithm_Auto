/*
아이디어 : 거리값을 비교하여 규칙을 찾아냄
a2 + b2 <= d2/k2
*/

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        double max = (double) d/k;
        
        for (long a=0; a <=max; a++) {
            
            answer += Math.floor(Math.sqrt(max*max-a*a))+1;
            
        }
        
        return answer;
    }
}