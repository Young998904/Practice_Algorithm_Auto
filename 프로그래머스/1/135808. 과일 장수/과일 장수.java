import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        // (1) 변수 선언
        int total = score.length;
        int box = total / m;
        
        // (2) score 배열 정렬
        Arrays.sort(score);
        
        // (3) 최솟값 확인
        int[] boxArr = new int[k+1];
        
        for (int i=1; i<= box; i++) {
            int min = score[score.length - m * i];
            boxArr[min]++;
        }
        
        // (4) 박스 계산
        int answer = 0;
        
        for (int i=1; i<boxArr.length; i++) {
            answer += i * m * boxArr[i];
        }
        
        return answer;
    }
}
/*
예시 1
[1, 2, 3, 1, 2, 3, 1]

[1, 1, 1, 2, 2, 3, 3] 7개
[0, 1, 2, 3, 4, 5, 6]
7 / 4 = 1 => 1개 박스 가능


7 - 4 * 1 = 3

예시 2
[4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]
[1, 1, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4] 12개
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11]
12 / 3 = 4 => 4개 박스 가능

12 - 3 * 1 = 9
12 - 3 * 2 = 6
12 - 3 * 3 = 3
12 - 3 * 4 = 0
*/