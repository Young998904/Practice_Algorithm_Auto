// // 방식 (1) : 반복문 활용 -> 효율성 테스트 실패
// class Solution {
//     public static int[] workArr;
//     public long solution(int n, int[] works) {
//         long answer = 0;
        
//         workArr = works;
        
//         int idx = 0;
        
//         for (int i=1; i<=n; i++) {
//             idx = maxIdx();
            
//             if (workArr[idx] == 0) continue;
            
//             workArr[idx] = workArr[idx] - 1;
//         }
        
//         for (int work : works) {
//             answer += work * work;
//         }
        
//         return answer;
//     }
    
//     public static int maxIdx () {
//         int maxIdx = 0;
//         int maxVal = -1;
        
//         for (int i=0; i<workArr.length; i++) {
//             if (workArr[i] > maxVal) {
//                 maxIdx = i;
//                 maxVal = workArr[i];
//             }
//         }
        
//         return maxIdx;
//     }
// }

// import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Collections;

// // 방식 (2) : 수학 -> 예외 케이스가 너무 많음
// class Solution {
//     public long solution(int n, int[] works) {
//         long answer = 0;
        
//         // (1) Sorting 을 위한 Array 생성
//         ArrayList<Integer> list = new ArrayList<>();
        
//         for (int i=0; i<works.length; i++) {
//             list.add(works[i]);
//         }
        
//         Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬
        
//         // 출력
//         System.out.println("내림 차순 정렬된 리스트");
//         for (int num : list) System.out.printf("%d ", num); 
//         System.out.println();
        
//         // (2) 최소 피로도 계산
//         int len = works.length;
        
//         int sum = 0;
//         for (int work : works) sum += work;
        
//         int m = (sum - n) / len; // 몫
//         int nn = (sum - n) % len; // 나머지
        
//         int[] minWork = new int[len];
        
//         for (int i=0; i<len; i++) {
//             if (i < nn) minWork[i] = m + 1;
//             else minWork[i] = m;
//         }
        
//         // 최소작업 출력
//         System.out.println("최소 작업 출력");
//         for (int work : minWork) System.out.printf("%d ", work);
//         System.out.println();
        
//         // (3) 작업 비교 및 최종값 출력
        
//         int a = 0;
//         int b = 0;
//         int gap = 0;
//         for (int j=len-1; j>=0; j--) {
//             a = list.get(j); // 원래값
//             b = minWork[j]; // 최소 작업
            
//             gap = b - a;
            
//             if (gap > 0) {
//                 b = a;
                
//                 // for (int k=1; k<=gap; k++) {
//                 //     minWork[j-k] += 1;
//                 //     if (j-k == 0) k = 
//                 // }
//                 int minus = 1;
//                 while (gap != 0) {
//                     minWork[j-minus] += 1;
                    
//                     gap--;
                    
//                     if (j-minus == 0) minus = 1;
//                     else minus++;
//                 }
//             }
            
//             System.out.println(b);
            
//             answer += b * b;
//         }
//         return answer;
//     }
// }
/*
[4, 8, 2, 5] 7
[8, 5, 4, 2] 7
5 5 4 2
4 5 4 2
4 4 4 2
4 3 3 2

[5, 5, 4, 2] 4
[5, 4, 4, 2] 3
[4, 4, 4, 2] 2

[4, 4, 2, 2] 0 = 16 16 4 4 = 32 8 = 40
[4, 3, 3, 2] 0 = 16 9 9 4 = 16 18 4 = 34 4 = 38

(1)
4 + 3 + 3 = 10
10 - 4 = 6
6 -> 3 = 2 & 2 & 2 (2 / 0)

(2)
2 + 1 + 2 = 5
5 -1 = 4
4 -> 3 = 2 & 1 & 1 (1 / 1)

(3)
1 + 1 = 2
2 - 3 = -1 (end)

(4)
6 + 1 + 1 = 8
8 - 3 = 5
5 -> 3 = 2 & 2 & 1 (1 / 2)

6 1 1
2 2 1
-> (재분배 과정)
3 1 1

1 6 1
2 2 1

6 1 1
3 1 1

4 + 8 + 2 + 5 = 12 + 7 = 19
19 - 7 = 12
12 -> 4 = 3 & 3 & 3 & 3 (3 / 0)
4 8 2 5

8 5 4 2 = 19 - 7 = 12

12 -> 4 = 3 & 3 & 3 & 3

8 5 4 2
3 3 3 3

3 3 4 2 = 9 9 16 4 = 18 16 4 = 20 + 18 = 38

8 4 5 2
4 4 4 2 5
4 3 3 2 7
16 9 9 4 = 16 + 18 + 4

10 10 1 = 21
21 - 10 = 11

10 10 1

4 4 3

4 6 1

*/
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // (1) 우선순위큐 생성 및 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) pq.add(work);
        
        int tmp = 0;
        int next = 0;
        
        while (n != 0) {
            tmp = pq.remove(); // 가장 큰 작업량
            next = pq.peek(); // 그 다음 작업량
            
            // System.out.printf("tmp : %d\n", tmp);
            // System.out.printf("next : %d\n", next);
            
            // // case1. tmp > next
            // if (tmp > next) {
            //     // case1-1. tmp 와 next 차이 <= n
            //     if (tmp-next+1 <= n) {
            //         pq.add(next-1); // 하나 작게 해서 삽입
            //         n -= tmp-next+1;
            //     }
            //     else {
            //         pq.add(tmp - n);
            //         n = 0;
            //     }
            // }
            
            
            
            if (tmp-next+1 <= n) {
                    pq.add(next-1); // 하나 작게 해서 삽입
                    n -= tmp-next+1;
                }
                else {
                    pq.add(tmp - n);
                    n = 0;
                }

        }
        
        for (int work : pq) {
            if (work < 0) continue;
            answer += work * work;
        }
        
        return answer;
    }
}
/*
8 4 5 2 / 7 / 38

8 5 4 2 | 7

8 5 = 3

5 5 4 2 | 4

5 5 = 0

4 4 4 2 | 2

4 4 = 0 

3 3 4 2 | 0

9 9 16 4 = 18 + 20 = 38

8 5 4 2 | 7
4 5 4 2 | 3
5 4 4 2 | 3
3 4 4 2 | 1
4 4 3 2 | 1
3 4 3 2 | 0
4 3 3 2 | 0

16 9 9 4 = 16 18 4 = 38

1 1 | 3

*/