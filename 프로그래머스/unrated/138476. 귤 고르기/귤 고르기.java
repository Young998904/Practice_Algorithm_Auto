import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // 크기의 max 값을 확인
        Arrays.sort(tangerine);
        int max = tangerine[tangerine.length-1];
        
        // 개수를 확인하는 count 배열 선언 및 정렬
        int[] count = new int[max+1];
        
        for (int i : tangerine) {
            count[i]++;
        }
        
        Arrays.sort(count);
        
        // 끝부터 확인
        for (int i=max; i>=0; i--) {
            if (k <= 0) {
                break;
            }
            
            if (count[i] > k) {
                answer++;
                break;
            }
            
            k -= count[i];
            answer++;
        }
        
        return answer;
    }
}
/*
(1) 개수가 중요하네? -> 크기를 index 로 하여 개수를 확인하는 배열 count 생성
(2) 얼마나 담아야하지? -> 개수가 많은 것부터 빼기 시작하여 k 값이 0 과 같거나 작아질 때 까지
*/