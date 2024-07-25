import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        // (1) 배열 선언 및 -1 로 초기화
        int[] minIdx = new int[26];
        Arrays.fill(minIdx, -1);
        
        // (2) 하나씩 처리 & 정답 추가
        int[] answer = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            int charNum = (int) s.charAt(i) - 97;
            
            // (2)-1 : -1 인 경우 => 그대로 값 저장
            if (minIdx[charNum] == -1) {
                answer[i] = -1;
            }
            // (2)-2 : 그 외 값인 경우 => 위치 차이 계산 후 저장
            else {
                answer[i] = i - minIdx[charNum];
            }
            
            minIdx[charNum] = i;
        }
        
        return answer;
    }
}
/*
(int) 'a' = 97 - 97 = 0;
(int) 'z' = 122 - 97 = 25;
*/