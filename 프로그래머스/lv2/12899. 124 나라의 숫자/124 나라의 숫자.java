
// // 방법 (1) 조합 (재귀) 사용
// class Solution {
//     public static int depth = 1;
//     public static int tmp = 0;
//     public static String answer = "";
//     public static boolean stop = false;
//     public static String[] str;
//     public static String[] nums = {"1", "2", "4"};
    
//     public String solution(int n) {
//         // 문자열의 길이 확인
//         int cnt = 3;
//         while (n > cnt) {
//             cnt += Math.pow(3, ++depth);
//         }
//         // 배열 생성
//         str = new String[depth];
        
//         // 그 전까지의 조합의 개수
//         for (int i=1; i<depth; i++) {
//             tmp += Math.pow(3, i);
//         }
        
//         // 조합 확인 & 결과 출력
//         comb(n, 0);
        
//         return answer;
//     }
//     public static void comb(int n, int d) {
//         if (d == depth) {
//             tmp++;
            
//             if (n == tmp) {
//                 for (String st : str) {
//                     answer += st;
//                 }
//                 stop = true;
//             }
//             return;
//         }
//         for (int i=0; i<3; i++) {
//             str[d] = nums[i];
//             if (stop) return;
//             comb(n, d+1);
//         }
//     }
// }

/*
1️⃣ 방법 (1) : 조합 (재귀) 사용
① 규칙 파악
                    0
      1             2               4
11 / 12 / 14    21 / 22 / 24     41 / 42 / 44
111/112/114
➡️ 순서가 있는 중복 조합의 형태

② 아이디어
입력을 통해 124 나라 숫자의 길이를 확인 후 이를 depth 로 한 조합 결과 확인
그 전까지의 개수 구하기
for (int i=0; i<depth; i++) {
    tmp += Math.pow(3, i);
}
③ 문자열의 길이 확인
(1) 1 - 3 = 1자리 (3개)
(2) 4 - 12 = 2자리 (9개)

2️⃣ 방법 (2) : 진수 변환
① 기존 10진법 ➡️ 3진법 변환과정 확인
3진법 ➡️ 0, 1, 2 만을 사용해서 수를 표현하는 방법
ex) 0 ➡️ 0(3) / 5 ➡️ 12(3) ...
② 관찰
➡️ 기존 3진법은 0부터 시작해서 한자리로 표현되는 것이 2 까지 인데, 현 문제는 1부터 시작해서 3까지 한자리로 표현됨
➡️ n 이 아닌 n-1 로 3진법을 수행하자!
➡️ 나머지 0 을 1 / 1 을 2 / 2 를 4로 변환하여 문자열로 만들자!
➡️ 몫의 경우 0 또는 1로만 구분됨 (유지)
③ 예외 발생
10 으로 실행하면 맨 첫자리가 0 이 올 수 없는 이유로 값이 틀어지기 시작
(다시 생각)

*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        while(n >= 3) {
            int q = n / 3;
            int r = n % 3;
            
            if(r == 0) {
                q = q-1;
                r = 4;
            }
            
            n = q;
            sb.append(r);
        }
        
        sb.reverse();
        
        if (n != 0) {
            sb.insert(0, n);
        }
        
        answer = sb.toString();

        return answer;
    }
}