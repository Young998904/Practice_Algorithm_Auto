import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;
        int tmp = 1; // 컨테이너 첫번째 택배 번호
        int idx = 0; // order 의 index
        
        Stack<Integer> stack = new Stack<>();
        
        while (idx != len) { // 종료 조건 : 모든 택배가 트럭에 다 담길 때까지
            // 배달 순서
            int box = order[idx];
            
            if (box == tmp) { // 경우1 : 배달 == 컨테이너
                idx++;
                tmp++;
                answer++;
                continue;
            }
            else if(box > tmp) { // 경우2 : 배달 > 컨테이너
                stack.push(tmp);
                tmp++;
                continue;
            }
            else { // 경우3 : 배달 < 컨테이너
                int top = stack.pop();
                
                if (top == box) {
                    idx++;
                    answer++;
                    continue;
                }
            }
            
            // 마지막 보조 컨테이너에서도 찾지 못하면 종료
            break;
        }
        
        return answer;
    }
}

/*
입력 분석
택배는 1,2,3,4,5.. 순서로 들어옴 (컨테이너)
order : 택배 기사님이 알려주신 배달 순서
출력 분석
실을 수 있는 박스의 최대수

보조 컨테이너의 형태
앞, 뒤로 움직일 수 있지만, 넣고 빼는 건 입구에서만 가능 -> Stack 형태

예시 분석)
4 3 1 2 5
택배 기사님이 정해준 택배 & 컨테이너의 택배의 조합은 다음과 같다
1) 기사님 택배 == 컨테이너 택배
-> 바로 트럭에 담는다. -> answer++ / order++ / tmp++
2) 기사님 택배 > 컨테이너 택배
-> 아직 차례가 오지 않았다. -> 컨테이너 택배를 보조 컨테이너(Stack) 에 담는다.
3) 기사님 택배 (1) < 컨테이너 택배 (4)
-> 보조 컨테이너에 이미 옮겨졌다. -> 보조 컨테이너의 top 을 확인해본다.

위 경우를 모두 훑은 뒤에도 찾지 못하면 반복문읜 종료된다.break

*/