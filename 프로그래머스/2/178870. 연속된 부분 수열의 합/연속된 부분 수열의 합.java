// 방법 (4)
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        
        ArrayList<int[]> answerList = new ArrayList<>();
        
        while (start < sequence.length && end < sequence.length) {
            // System.out.printf("현재 sum : %d\n", sum);
            if (sum <= k && end < sequence.length) {
                if (sum == k) {
                    answerList.add(new int[] {start, end});
                    // System.out.println("정답추가");
                    
                } 
                
                if (end+1 < sequence.length) {
                    sum += sequence[++end];
                    // System.out.printf("변경 sum : %d\n", sum);
                }
                else break;
            }
            else {
                sum -= sequence[start++];
                // System.out.printf("변경 sum : %d\n", sum);
            }
            
            // System.out.printf("현재 위치 : start (%d) / end (%d)\n", start, end);
        }
        
        int minLen = sequence.length;
        int minStart = sequence.length;
        int minEnd = 0;
        
        for (int[] arr : answerList) {
            // System.out.printf("%d / %d\n", arr[0], arr[1]);
            if (arr[1]-arr[0] == minLen && arr[0] < minStart) {
                minStart = arr[0];
                minEnd = arr[1];
                minLen = arr[1]-arr[0];
            }
            else if (arr[1]-arr[0] < minLen) {
                minStart = arr[0];
                minEnd = arr[1];
                minLen = arr[1]-arr[0];
            }
        }
        
        return new int[] {minStart,minEnd};
    }
}

// // 방법 (3) : 배열 갱신 / 결과 => 58.8
// /*
// [1, 2, 3, 4, 5] 원래

// [1, 2, 3, 4, 5] new (1)

// [1 (0), 3(0+1), 5(1+2), 7(2+3), 9(3+4)] new (2)

// [1 (0), 3(0+1), 6(0+1+2), 9(1+2+3), 12(2+3+4)] new (3) k?

// */
// class Solution {
//     public int[] solution(int[] sequence, int k) {
//         // (1) 한개만 전체 탐색 : O(n)
//         for (int i=0; i<sequence.length; i++) {
//             if (sequence[i] == k) return new int[] {i,i};
//         }
        
//         // (2) 나머지 경우
//         int[] arr = sequence.clone(); // 배열 복사
        
//         for (int len=1; len<sequence.length; len++) {
//             for (int i=len; i<sequence.length; i++) {
//                 arr[i] += sequence[i-len];
                
//                 if (arr[i] == k) return new int[]{i-len, i};
//             }
//         }
        
//         return new int[] {0,0};
//     }
// }

// // 방법 (2) : 확인할 len 의 범위를 늘려가며 바로 확인 후 정답시 리턴 / 결과 => 50
// class Solution {
//     public int[] solution(int[] sequence, int k) {
        
//         // (1) 한개의 원소로 해결 가능한 경우 ➡️ 바로 정답 리턴
//         for (int i=0; i<sequence.length; i++) {
//             if (sequence[i] == k) return new int[] {i,i};
//         }
        
//         // (2) 나머지 경우
//         for (int len=2; len<=sequence.length; len++) {
//             for (int i=0; i<sequence.length-len; i++) {
//                 int sum = sequence[i];
                
//                 for (int j=1; j<len; j++) {
//                     sum += sequence[i+j];
//                 }
                
//                 if (sum == k) return new int[] {i, i+len-1};
//             }
//         }
        
//         return new int[] {0,0};
//     }
// }

// // (1) 단순 완전 탐색 ➡️ 시간 초과 / 결과 => 58.8
// class Solution {
//     public int[] solution(int[] sequence, int k) {
        
//         // (1) 정답을 담을 answer 배열 (우선 최악의 경우로 세팅)
//         int[] answer = new int[] {0, sequence.length-1};
//         int minLen = sequence.length-1;
        
//         for (int i=0; i<sequence.length-1; i++) {
//             int sum = sequence[i];
            
//             // (2)-1 : 단일 인덱스로 만족하는 경우 바로 정답 리턴 (최소 만족)
//             if (sum == k) return new int[] {i,i};
            
//             for (int j=i+1; j<sequence.length; j++) {
//                 if (minLen < j-i) break;
                
//                 sum += sequence[j];
                
//                 // (2)-2 : 조건을 만족할 경우 기존 정답과 비교
//                 if (sum == k && j-i <= minLen) {
//                     if (j-i == minLen && i > answer[0]) break;
//                     answer[0] = i;
//                     answer[1] = j;
//                     minLen = j-i;
                    
//                     break;
//                 }
//             }
//         }
        
//         // (3) 마지막 인덱스가 조건을 만족할 경우 바로 정답 리턴
//         if (minLen > 0 && sequence[sequence.length-1] == k) {
//             return new int[] {sequence.length-1,sequence.length-1};
//         }
        
//         return answer;
//     }
// }