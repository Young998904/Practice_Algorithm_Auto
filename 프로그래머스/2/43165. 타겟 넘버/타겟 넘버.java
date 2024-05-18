// class Solution {
//     public static boolean[] visited;
//     public static int[] nums;
//     public static int t;
//     public static int answer = 0;
    
//     public int solution(int[] numbers, int target) {
//         visited = new boolean[numbers.length];
//         nums = new int[numbers.length*2];
//         int idx=0;
        
//         // 초기화
//         for (int i=0; i<numbers.length; i++) {
//             nums[idx++] = numbers[i];
//             nums[idx++] = numbers[i] * (-1);
//         }
        
//         t = target;
        
//         dfs (0, 0);
        
//         return answer;
//     }
//     public static void dfs (int depth, int sum) {
//         if (depth == nums.length && sum == t) {
//             answer++;
//         }
//         for (int i=0; i<nums.length; i++) {
            
//         }
//     }
// }

class Solution {
    public static int[] numbers;
    public static int target;
    public static int answer;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.answer = 0;
        
        dfs (0,0);
        
        return answer;
    }
    public static void dfs (int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum - numbers[depth]);
    }
}
/*
(1) 생각정리
    (가) 한번씩만 사용가능
    (나) 더하기 또는 빼기 가능
    (다) 중요한건 마지막에 타깃 넘버가 되었는지
    (라) 숫자의 순서보다 중요한건 단순히 + / - 부호 일것
(2) 해결방법
    (가) 이진 트리 구조로 +4 -4 이런식의 숫자를 더해간다
        ➡️ dfs 돌릴 때 두가지 버전으로 돌린다.?
            dfs (depth+1, arr, sum+num);
            dfs (depth+1, arr, sum-num);
        이렇게 하니깐 StackOverFlow Error 발생
        
    (나) 그럼 애초에 배열을 +4, -4, +2, -2 이렇게 만들어서 돌릴까?
        ➡️ 훑는 과정이 어려움
    (다) (가) 의 방법을 수정
    
(3) 고민되는 부분
    (가) 예를 들어 타겟 숫자가 6이고 수어진 배열이 [4,2,1,1] 일때
        ➡️ 4 + 2 - 1 + 1 = 6
        ➡️ 4 + 2 + 1 - 1 = 6
        이 둘은 같은 결과인데 겹치는건 어떻게 제외하는지
        ➡️ 예시 1보니깐 둘 다 정답으로 인정 (해결)
*/