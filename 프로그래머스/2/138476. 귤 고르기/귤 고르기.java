import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // (1) tangerine 배열 정렬
        Arrays.sort(tangerine); // [1, 2, 2, 3, 3, 4, 5, 5];
        
        // (2) tangerine 중 가장 큰 사이즈 크기 만큼의 배열 생성
        int[] cntArr = new int[tangerine[tangerine.length-1]+1];
        
        // (3) 전체 탐색하며 cntArr 배열 갱신
        for (int size : tangerine) {
            cntArr[size]++;
        }
        
        // (4) cntArr 배열 정렬
        Arrays.sort(cntArr);
        
        // (5) 맨 뒤에서부터 k 값 빼가면서 k 가 0 보다 작거나 같아질 때 까지 반복
        int idx = cntArr.length-1;
        
        while (k > 0) {
            k -= cntArr[idx--];
            answer++;
        }
        
        return answer;
    }
}