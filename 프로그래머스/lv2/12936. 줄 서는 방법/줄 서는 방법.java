// // 방법 (1) : 순열 사용 -> 효율성 테스트 통과 X
// class Solution {
//     public static boolean[] visited;
//     public static int[] answer;
//     public static int nn;
//     public static long kk;
//     public static long cnt = 0;
//     public static boolean stop = false;
    
//     public int[] solution(int n, long k) {
//         // 초기화
//         visited = new boolean[n+1];
//         answer = new int[n];
//         kk = k;
//         nn = n;
        
//         // n-1! 개수 세기
//         long total = 1;
//         for (int i=2; i<n; i++) {
//             total *= i;
//         } 
        
//         int start = (int) ((k-1) / total) +1;
//         cnt = (start-1) * total;
        
//         visited[start] = true;
//         answer[0] = start;
        
//         perm(1);
        
//         return answer;
//     }
//     public static void perm(int depth) {
//         if (depth == nn) {
//             if (++cnt == kk) {
//                 stop = true;
//             } 
//             return;
//         }
        
//         for (int i=1; i<=nn; i++) {
//             if (stop) return;
            
//             if (visited[i]) continue;
            
//             visited[i] = true;
//             answer[depth] = i;
            
//             perm(depth+1);
            
//             if(stop) return;
            
//             visited[i] = false;
//         }
//     }
// }

// 방법 (2) : 수학적 풀이
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int cnt = 0;
        List<Integer> nums = new ArrayList<>();
        
        // n! 값 구하기
        long fac = 1;
        for (int i=1; i<=n; i++) {
            fac *= i;
            nums.add(i);
        }
        
        long unit;
        k--;
        while (n >= 1) {
            unit = fac / n;
            int nn = (int) (k / unit);
            
            answer[cnt] = nums.get(nn);
            nums.remove(nn);
            
            k %= unit;
            
            cnt++;
            n--;
            fac = unit;
        }
        
        return answer;
    }
}