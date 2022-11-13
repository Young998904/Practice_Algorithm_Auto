import java.util.Stack;
import java.util.Arrays;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        // 단어를 담음
        Stack<String> stack = new Stack<>();
        // 차례
        int[] times = new int[n+1];
        Arrays.fill(times, 1);
        // 첫번째 단어는 무조건 통과
        stack.push(words[0]); // 첫번째
        times[1] ++;
        
        
        for (int i=1; i<words.length; i++) {
            int turn = i % n + 1; // 현재 차례의 번호
            String before = stack.peek(); // 이전 차례의 사람이 말한 단어
            String after = words[i]; // 현재 차래의 사람이 말한 단어
            
            // 규칙 위반 (1) 단어 불일치
            if (before.charAt(before.length()-1) != after.charAt(0)) {
                answer[0] = turn;
                answer[1] = times[turn];
                return answer;
            }
            // 규칙 위반 (2) 중목
            if (stack.search(after) != -1) {
                answer[0] = turn;
                answer[1] = times[turn];
                return answer;
            }
            
            stack.push(after);
            times[turn]++;
        }

        return answer;
    }
}
/*
차례확인
int turn
단어확인
Stack 활용
반복문 사용
for (배열의 크기)
1. 그 전에 return answer;
2. 성공하면 [0,0] return;
번호 (가장 먼저 탈락하는 사람의 번호)
-> 현재 스택의 크기 %(참여하는 사람의 수) + 1
몇번째 (그 사람이 몇번째 턴인지)
-> 배열을 만들어서 하나씩 더해주는게 맞을듯 (현재 번호 : 번호 방식과 동일)
반복문 루틴
1. 단어 빼내고
2 -1. 끝말잇기 맞는지 확인
2 -2. 단어 있는지 확인
3 -1. stack 에 넣기
*/