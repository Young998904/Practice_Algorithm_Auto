class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n == 0) {
            return answer;
        }
        else if (n == 1) {
            return 1;
        }
        
        for (int i=2; i<n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        
        return answer+1+n;
    }
}