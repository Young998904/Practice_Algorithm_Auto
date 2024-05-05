import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // System.out.println((int) Math.ceil((double) (100-progresses[1]) / speeds[1]));
        
        int size = progresses.length;
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        
        int day = 0;
        for (int i=size-1; i>=0; i--) {
            day = (int) Math.ceil((double) (100-progresses[i]) / speeds[i]);
            stack.push(day);
            // System.out.printf("%d ", day);
        }
        System.out.println();
        
        int tmp = 0;
        int next = 0;
        int cnt = 1;
        
        while (!stack.empty()) {
            if (stack.size() == 1)  {
                // System.out.println("1개 남음");
                answer.add(1);
                break;
            }
            
            tmp = stack.pop(); // 가장 최신
            next = stack.pop();
            // System.out.printf("이번 작업 시작 값 : %d \n", tmp);
            
            while (true) {
                if (tmp >= next) {
                    cnt++;
                    // System.out.printf("함께 처리되는 값 : %d \n", next);
                    if (!stack.empty()) {
                        tmp = tmp > next? tmp : next;
                        next = stack.pop();
                        continue;
                    }
                }
                else {
                    stack.push(next);
                }
                answer.add(cnt);
                cnt = 1;
                break;
            }
        }
        
        // int[] answerArr = answer.toArray(new int[0]);
        int[] answerArr = answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answerArr;
    }
}

/**
Queue 사용
객체 저장 (Job_int endDay)
93 -> (long) 7 / 1 = 7.0 -> 7
30 -> (long) 70 / 30 = 2.xx = 3
55 -> (long) 45 / 5 = 9.0 = 9
7 3 => 2
11 = > 1
**/