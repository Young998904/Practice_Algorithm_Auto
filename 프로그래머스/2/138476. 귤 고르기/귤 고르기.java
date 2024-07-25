import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int[] cntArr = new int[tangerine[tangerine.length-1]+1];
        
        for (int size : tangerine) {
            cntArr[size]++;
        }
        
        Arrays.sort(cntArr);
        
        int idx = cntArr.length-1;
        while (k > 0) {
            k -= cntArr[idx--];
            answer++;
        }
        
        return answer;
    }
}
