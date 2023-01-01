import java.util.Queue;
import java.util.LinkedList;

class job {
    int index;
    int priority;
    
    public job (int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Solution {
    public static Queue<job> q = new LinkedList<job>();
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        for (int i=0; i<priorities.length; i++) {
            q.add(new job(i, priorities[i]));
        }
        
        job j = new job(-1, -1);
        int prior = 0;
        
        while (j.index != location) {
            answer++;
            // 우선 순위 max 값 확인
            for (int i=0; i<priorities.length; i++) {
                prior = Math.max(prior, priorities[i]);
            }
            for (int i=0; i<priorities.length; i++) {
                if (priorities[i] == prior) {
                    priorities[i] = 0;
                    break;
                }
            }
            j = printer(prior);
            prior = 0;
        }
        
        return answer;
    }
    
    public static job printer(int max) {
        job j;
        while (true) {
            j = q.remove();
            if (j.priority == max) {
                return j;
            }
            System.out.println(j.index);
            q.add(j);
        }
    }
}

/*
작동순서 생각해보기
예제(1)
2(A) 1(B) 3(C) 2(D)
1(B) 3(C) 2(D) 2(A)
3(C) 2(D) 2(A) 1(B)
-> 2번째 위치 3(C) 는 차례 1
예제(2)
1(A) 1(B) 9(C) 1(D) 1(E) 1(F)
1(B) 9(C) 1(D) 1(E) 1(F) 1(A)
9(C) 1(D) 1(E) 1(F) 1(A) 1(B)
-> 0번째 위치 1(A) 는 차례 5

(1) 앞에서 빼고 만약 우선 순위가 밀리면 뒤로 빼는 상황
=> Queue 가 적합
(2) 같은 숫자를 어떻게 구별할지
가) 다른 번호를 부여? -> 우선순위 비교가 불가능해짐
나) 최종배열에 인덱스를 담자 -> 실패
다) Map 활용 <"인덱스","우선순위"> -> 굳이?
라) Class 생성
(3) 언제까지 반복해야할까
가) 모든 프린트가 출력될 때까지
나) 하나까 출력될 때 마다
*/