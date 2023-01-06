// // 방법 (1) -> 효율성 테스트 통과 x
// class Solution {
//     boolean solution(String s) {
//         int total = 0;
        
//         String[] str = s.split("");
        
//         for (int i=0; i<str.length; i++) {
//             if (total < 0) {
//                 return false;
//             }
            
//             String tmp = str[i];
            
//             if (tmp.equals("(")) {
//                 total++;
//                 continue;
//             }
//             total--;
//         }
        
//         if (total == 0) {
//             return true;
//         }
        
//         return false;
//     }
// }

// // 방법 (2) -> 효율성 테스트 통과 x
// import java.util.Stack;

// class Solution {
//     boolean solution(String s) {
//         Stack<String> box = new Stack<>();
        
//         String[] str = s.split("");
        
//         for (String ss : str) {
//             if (box.isEmpty()) {
//                 box.push(ss);
                
//                 continue;
//             }
            
//             String match = box.peek() + ss;
            
//             if (match.equals("()")) {
//                 box.pop();
//                 continue;
//             }
            
//             box.push(ss);
//         }
        
//         if (box.isEmpty()) {
//             return true;
//         }
        
//         return false;
//     }
// }
// import java.util.Stack;

// class Solution {
//     boolean solution(String s) {
//         Stack<Character> box = new Stack<>();
//         char[] c = s.toCharArray();
//         int sum = '('-')'; // -1

//         for (char ss : c) {
//             if (box.isEmpty()) {
//                 box.push(ss);

//                 continue;
//             }

//             if (sum == box.peek()-ss) {
//                 box.pop();
//                 continue;
//             }

//             box.push(ss);
//         }
        
//         if (box.isEmpty()) {
//             return true;
//         }
        
//         return false;
//     }
// }

// 방법 (1) -> 효율성 테스트 통과 x
class Solution {
    boolean solution(String s) {
        int total = 0;
        
        int left = '(';
        
        char[] str = s.toCharArray();
        
        for (int i=0; i<str.length; i++) {
            if (total < 0) {
                return false;
            }
            
            if (str[i] == left) {
                total++;
                continue;
            }
            total--;
        }
        
        if (total == 0) {
            return true;
        }
        
        return false;
    }
}

/*
예시 분석
()() 1 0 1 0
(())() 1 2 1 0 1 0
((())()) 
())(() 1 0 -1 0 1 0
1 2 0 1

( 를 +1 )를 -1로 보았을 때 합이 음수가되면 안된다.

스택을 이용한다면
(1) 비었을 때 -> 바로 넣는다
(2) 비어있지 않을 때
-> 맨위를 꺼낸다
-> 다음것과 합쳐본다
-> () 가 되면 빼내고 아니면, 추가로 넣는다.
(3) 다 돌았을 때 empty() 가 아니면 false
*/