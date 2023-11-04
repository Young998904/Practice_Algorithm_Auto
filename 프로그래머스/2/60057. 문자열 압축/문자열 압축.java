// class Solution {
//     public int solution(String s) {
//         int answer = s.length(); // 문자열 전체 길이일 때 max 값
        
//         // 문자열의 길이 확인
//         int total = s.length();
//         System.out.println(total); 
        
//         // 절반값 확인 _ 절반값 : 자를 수 있는 가장 큰 단위
//         int maxLen = total / 2;
        
//         // maxLen 부터 단위가 1이 될 때 까지 하나씩 확인 
//         int result = 0; // 문자열을 다 줄인 후 결과 값
//         int ops = 0; // 문자열 현재 위치
//         int check = 0; // 확인할 문자열의 시작 위치
//         int count = 0; // 연속되는 문자열의 수
//         String str = ""; // 반복 문자열
//         String newStr = ""; // 확인할 문자열
        
//         for (int len = maxLen; len >= 1; len--) { // len : 문자열 단위
//             // 변수 초기화
//             ops = 0;
//             check = ops + len;
//             str = s.substring(ops, ops+len);
            
//             while (ops > total) { // 현재 위치가 길이를 벗어나면 멈춤
//                 newStr = s.substring(check, check+len);
//                 // 경우(1) 두 문자열이 같은 경우
//                 if (newStr.equals(str)) { 
//                     count++;
//                     check += len;
//                     System.out.printf("문자열 : %s / 반복 : %d 번", str, count);
//                     continue;
//                 }
//                 // 경우(2) 두 문자열이 다른 경우
//                 else {
//                     ops = check;
//                     str = s.substring(ops, ops+len);
//                     count = 0;
//                     check += len;
//                 }
//                 // 결과 반영
//                 result = total - (len*count) + 1;
                
//             }
            
//             // 마지막은 항상 answer 값 비교
//             if (result < answer) {
//                 answer = result; // 정답 갱신
//             }
//         }
        
//         return answer;
        
        
//     }
// }

// // 일단 원하는 길이로 자를 수 있는 알고리즘 구현
// class Solution {
//     public int solution(String s) {
//         int answer = s.length();
        
//         int len = 6; // n단위로 잘라보기
        
//         int ops = 0; // 문자열 현재 위치
//         int check = ops + len; // 확인할 문자열의 시작 위치
//         int count = 0; // 연속되는 문자열의 수
//         String str = s.substring(ops, ops+len); // 반복 문자열
//         System.out.printf("반복 문자열 : %s \n", str);
//         String newStr = ""; // 확인할 문자열
        
//         while (ops < s.length()) {
//             if (check+len > s.length()) break;
//             newStr = s.substring(check, check+len);
//             // 경우 (1) 두 문자열이 동일한 경우
//             if (str.equals(newStr)) {
//                 System.out.printf("str : %s / newStr : %s \n", str, newStr);
//                 ops = check; // 현재 문자열 위치 변경 
//                 check += len; // 다음 len 단위 문자열 확인
//                 count++; // 반복된 수 더하기
//                 System.out.printf("확인 문자열 : %s 이 %d번 반복됨\n", newStr, count);
//                 continue; // 계속 진행
//             }
//             // 경우 (2) 두 문자열이 다른 경우
//             else {
//                 ops = check; // 현재 문자열 위치 변경
//                 check += len; // 다음 len len 단위 문자열 확인
//                 str = newStr; // 반복 문자열 갱신
//                 System.out.printf("새로운 반복 문자열 : %s \n", str);
//             }
//             // 결과 반영
//             if (count > 0) {
//                 answer = answer - (count*len) + 1;
//                 count = 0; // count 수 초기화
//             }
//         }
//         if (count > 0) {
//             answer = answer - (count*len) + 1;
//         }
//         return answer;
//     }
// }

// 여러 길이를 확인하도록 전환
class Solution {
    public int solution(String s) {
        int answer = s.length();
        int total = s.length();
        int maxLen = total / 2;
        
        for (int len = maxLen; len >= 1; len--) {
            // System.out.printf("len : %d 일 때\n", len);
            
            // 값들 초기화
            int cntLen = 0;
            int result = total;
            int ops = 0; // 문자열 현재 위치
            int check = ops + len; // 확인할 문자열의 시작 위치
            int count = 0; // 연속되는 문자열의 수
            String str = s.substring(ops, ops+len); // 반복 문자열
            // System.out.printf("반복 문자열 : %s \n", str);
            String newStr = ""; // 확인할 문자열
            
            while (ops < total) {
                if (check+len > total) break; // 자르기 불가능할 경우 멈춤
                 newStr = s.substring(check, check+len);
                
                // 경우 (1) 두 문자열이 동일한 경우
                if (str.equals(newStr)) {
                    // System.out.printf("str : %s / newStr : %s \n", str, newStr);
                    ops = check; // 현재 문자열 위치 변경 
                    check += len; // 다음 len 단위 문자열 확인
                    count++; // 반복된 수 더하기
                    // System.out.printf("확인 문자열 : %s 이 %d번 반복됨\n", newStr, count);
                    continue; // 계속 진행
                }
                // 경우 (2) 두 문자열이 다른 경우
                else {
                    ops = check; // 현재 문자열 위치 변경
                    check += len; // 다음 len len 단위 문자열 확인
                    str = newStr; // 반복 문자열 갱신
                    // System.out.printf("새로운 반복 문자열 : %s \n", str);
                }
                // 결과 반영
                cntLen = String.valueOf(count+1).length();
                if (count > 0) {
                    result = result - (count*len) + cntLen;
                    count = 0; // count 수 초기화
                }
            }
            
            if (count > 0) { // 결과 반영
                cntLen = String.valueOf(count+1).length();
                result = result - (count*len) + cntLen;
            }
            
            if (result < answer) { // 최소값 비교
                answer = result;
            }
        }        
        
        return answer;
    }
}