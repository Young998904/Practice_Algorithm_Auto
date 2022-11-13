import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
//         // 방법(1) 단순 문자열 활용 : 테스트 케이스는 통과했는데 효율성 테스트 실패
//         boolean turn = true;
//         while (turn) {
//             turn = false;
            
//             for (int i=0; i<s.length()-1; i++) {
//                 if (s.charAt(i) == s.charAt(i+1)) {
//                     String a = s.substring(0,i);
//                     String b = s.substring(i+2);
//                     s = a+b;
//                     turn = true;
//                     break;
//                 }
//             }
//         }
        
//         if (s.length() == 0) {
//             return 1;
//         }
        
        // 방법 (2) 스택 활용
        Stack <Character> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        
        if (stack.empty()) {
            return 1;
        }
        
        return answer;
    }
}
/*
baabaa
while (true) {
    for (int i=0; i<(길이)-1; i++) { // 완전 탐색
        if ( i문자 - i+1문자 == 0) {
            둘 다 제거 -> 길이가 달라지는데? 다른걸로 대체한다? (o)
            빈문자열로 대체하자!
        }
    }
    if (이전 자료구조의 크기 == 수정 후 자료구조의 크기) {
        break;
    }
}

// 문자열로 만들어서 반환한다
*/