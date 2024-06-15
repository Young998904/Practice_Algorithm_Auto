import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // (1) 배열 정렬
        Arrays.sort(citations);
        
        // (2) 이분 탐색 수행
        int left = Math.min(citations[0], citations.length);
        int right = citations[citations.length-1];
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (isPossible(mid, citations)) {
                answer = Math.max(answer, mid);
                left = mid+1;
            }
            else {
                right = mid-1;
            }
            
        }
        
        return answer;
        
    }
    /*
        해당 h 값이 조건을 만족하는지 확인하는 함수
        int h : h 값
        int[] citations : 주어진 citations 배열
    */
    public static boolean isPossible(int h, int[] citations) {
        if (h > citations.length) return false;
        
        int min = Math.max(0, citations.length-h);
        for (int i=citations.length-1; i>=min; i--) {
            if (citations[i] < h) return false;
        }
        
        return true;
    }
}
/*
[3, 0, 6, 1, 5]
[0, 1, 3, 5, 6]

[0, 1, 5, 5, 6]
*/

// import java.util.Arrays;
// 
// class Solution {
//     public int solution(int[] citations) {
//         int answer = 0;
//         // 배열 정렬 (오름 차순)
//         Arrays.sort(citations);
//         // 초기화
//         int size = citations.length;
//         // 탐색
//         for (int i=size-1; i>=0; i--) { // i=4 부터 시작
//             int now = citations[i];
            
//             if (now > size) {
//                 continue;
//             }
            
//             if (now > size-i) {
//                 continue;
//             }
            
//             if (i > now) {
//                 continue;
//             }
            
//             answer = now;
//             break;
//         }
        
//         return answer;
//     }
// }
// /*
// Case1 : [3, 0, 6, 1, 5]
// 15 % 5 = 3
// 바로 가능 but 편차가 큰 경우 문제 발생 가능
// Case2 : [1, 5, 7, 3]
// 16 % 4 = 4
// 4번 이상 인용된 논문 2개 -> fail
// 3번 이상 인용된 논문 3개 -> success

// => 방법(1) 평균을 h의 최댓값으로 설정한 후 하나씩 내려서 확인한다.

// => 방법(2) 배열이 주어졌을 때는 일단 정렬 시의 이점에 대해 생각해본다.
// [3, 0, 6, 1, 5] -> [0, 1, 3, 5, 6]
// 맨 뒤부터 확인
// 4번 인덱스 6 -> 전체 논문 수 보다 큼
// 3번 인덱스 5 -> 전체 논문 수와 같음 but 이상인 논문이 5-3 = 2로 적음
// 2번 인덱스 3 -> 전체 논문 수 보다 작음 & 이상인 논문이 5-2 = 3 으로 같음
// 따라서 정답 3
// Case2 : [1, 5, 7, 3] -> [1, 3, 5, 7]
// 3번 인덱스 7 -> 전체 논문 수 보다 큼
// 2번 인덱스 5 -> 전체 논문 수 보다 큼
// 1번 인덱스 3 -> 전체 논문 수 보다 작은 & 이상인 논문이 4-1=3 로 같음
// 따라서 정답 3
// */