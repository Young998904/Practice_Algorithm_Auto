import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        // 필요한 보트의 개수
        int answer = 0;
        // 탈출해야하는 사람의 수
        int left = people.length; 
        
//         int me = 0;
//         int with = 0;
//         int max = 0;
        
//         // 전체가 탈출할 때까지 반복
//         while (left > 0) {
//             // 이미 탈출한 사람일 경우 pass
//             if (people[me] == -1) {
//                 me++;
//                 continue;
//             }
//             // 몸무게가 limit 인 사람일 경우 바로 태움
//             if (people[me] == limit) {
//                 me++;
//                 answer++;
//                 left--;
//                 continue;
//             }
//             // 본격적인 탐색 시작
//             for (int i=me+1; i<people.length; i++) {
//                 // 만약 i번째 사람이 이미 탈출한 경우 pass
//                 if (people[i] == -1) {
//                     continue;
//                 }
//                 // 몸무게 합
//                 int sum = people[me] + people[i];
                
//                 // limit 값과 일치할 경우 바로 태워 보냄
//                 if (sum == limit) {
//                     people[me] = -1;
//                     people[i] = -1;
                    
//                     answer++;
//                     left = left - 2;
//                     me++;
                    
//                     // 초기화
//                     max = 0;
//                     break;
//                 }
//                 // 그렇지 않을 경우 합이 가장 큰사람과 함께 탈출 시킴
//                 if (sum < limit && sum > max) {
//                     max = sum;
//                     with = i;
//                 }
//             }
//             // 함께 할 수 있는 사람이 없는 경우 -> 혼자 탈출
//             if (max == 0) {
//                 people[me] = -1;
                
//                 answer ++;
//                 left--;
//                 me++;
//             }
//             else { // 함께 할 수 있는 사람이 있는 경우 -> 함께 탈출
//                 people[me] = -1;
//                 people[with] = -1;
//                 answer ++;
//                 left = left -2;
//                 me++;
            
//                 max = 0;
//             }
//         }
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length-1;
        
        while (left > 0) {
            
            int sum = people[start] + people[end];
            
            if (sum <= limit) {
                answer++;
                left = left - 2;
                start++;
                end--;
            }
            else {
                answer++;
                left--;
                end--;
            }
        }
        
        return answer;
    }
}