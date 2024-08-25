import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        // (1) 초기값 저장
        int[] wanho = new int[] {scores[0][0], scores[0][1]};
        
        // (2) 정렬 : 근무 태도 (내림차순) / 동료 평가 (오름차순)
        Arrays.sort(scores, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        // (3) 순회하며 등수 측정
        int answer = 1;
        int maxPoint = scores[0][1]; // 동료 평가 초기 Max 값으로 초기화
        int wanhoSum = wanho[0]+wanho[1];
        
        for (int[] score : scores) {
            if (score[1] < maxPoint) { 
                // 동료 평가를 기준으로 오름차순 했기 때문에 해당 조건을 만족한다는 것은 근무 태도도 낮다는 것을 의미
                // 탈락 대상
                if (score[0] == wanho[0] && score[1] == wanho[1]) return -1;
            }
            else {
                // maxPoint 갱신
                maxPoint = Math.max(maxPoint, score[1]);
                
                // 완호랑만 비교하여 등수를 갱신해나간다
                if (score[0]+score[1] > wanhoSum) answer++;
            }
        }
        
        return answer;
    }
}

// import java.util.PriorityQueue;

// // Score 클래스 생성
// class Score implements Comparable<Score> {
//     boolean isWanho; // 완호 여부
//     int score_1; // 첫번째 점수
//     int score_2; // 두번째 점수
//     int sum; // 점수 합계
    
//     // 생성자
//     public Score (int score_1, int score_2, int index) {
//         if (index == 0) this.isWanho = true;
//         else this.isWanho = false;
        
//         this.score_1 = score_1;
//         this.score_2 = score_2;
//         this.sum = score_1 + score_2; // 합계를 구한다
//     }
    
//     @Override
//     public int compareTo (Score other) { // 점수 합계 기준 내림차순 
//         if (other.sum == this.sum) {
//             if (other.score_1 == this.score_1) return other.score_2 - this.score_2;
//             return other.score_1 - this.score_1;
//         }
        
//         return other.sum - this.sum;
//     }
// }

// class Solution {
//     /*
//     getIncentive : 인센티브를 받을 수 있는지 여부
//     rate : 등수
//     delay : 점수합계가 같은 사람들의 수
//     */
//     public static boolean getIncentive = true;
//     public static int rate = 1;
//     public static int delay = 0;
    
//     public int solution(int[][] scores) {
//         int answer = 0;
        
//         // (1) PriorityQueue 생성 및 점수 정리
//         PriorityQueue<Score> pq = new PriorityQueue<>();
            
//         for (int i=0; i<scores.length; i++) {
//             pq.add(new Score(scores[i][0], scores[i][1], i));
//         }
        
//         // (2) 완호를 찾으면서 순위 및 인센티브 확인
//         Score first = pq.poll();
        
//         if (first.isWanho) return 1;
        
//         while (!pq.isEmpty()) {
//             Score second = pq.poll();
            
//             compare (first, second);
            
//             if (second.isWanho) {
//                 if (!getIncentive) return -1;
//                 return rate;
//             }
            
//             first = second;
//         }
        
//         return rate;
//     }
//     /*
//         등수 및 인센티브 지급 여부를 확인하기 위한 함수
//     */
//     public static void compare (Score first, Score second) {
//         // (1) 합계가 같은 경우 ➡️ delay 변수 1 증가 후 바로 종료
//         if (first.sum == second.sum) {
//             delay++;
//             return;
//         }
        
//         //  (2) 두 점수 모두 낮은 경우 ➡️ getIncentive 변수 false 전환
//         if (second.score_1 < first.score_1 && second.score_2 < first.score_2) {
//             getIncentive = false;
//         }
        
//         // 등수 조정 및 delay 변수 초기화
//         rate = rate + delay + 1;
//         delay = 0;
        
//         return;
//     }
// }
/*
[3,4] rate 1 delay 0 getIncentive true
[2,5] rate 1 delay 1 getIncentive true
[2,2] rate 3 delay 0 getIncentive true
[1,1] getIncentive false
[0,2] -> 예외 (처리)

 원호=(5,5) A=(11,2) B=(10,1)
 
 10 1
 10 9
 9 2
 9 10
 8 2
 5 3
 5 5 동점
 4 6 동점
 
 [3,2]
 [3,2]
 [2,1] (탈락)
 [2,2] (완)
 [1,4]
 
*/