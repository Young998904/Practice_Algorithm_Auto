// class Solution {
//     public int solution(int k, int[][] dungeons) {
//         int answer = 0;
        
//         // (1) 정렬
//         for (int i=1; i<dungeons.length; i++) {
//             for (int j=0; j<dungeons.length-i; j++) {
                
//                 if (dungeons[j][1] == dungeons[j+1][1]) {
//                     if (dungeons[j][0] > dungeons[j+1][0]) {
//                         int[] temp = dungeons[j];
//                         dungeons[j] = dungeons[j+1];
//                         dungeons[j+1] = temp;
//                     }
//                 }
                
//                 if (dungeons[j][1] > dungeons[j+1][1]) {
//                     int[] temp = dungeons[j];
//                     dungeons[j] = dungeons[j+1];
//                     dungeons[j+1] = temp;
//                 }
//             }
//         }
        
//         // 앞에서부터 탐색
//         int index = 0;
        
//         while (k > 0 && index < dungeons.length) {
//             if (k >= dungeons[index][0]) {
//                 answer++;
//                 k -= dungeons[index][1];
//                 index++;
//                 System.out.println(k);
//                 continue;
//             }
//             index++;
//         }
        
//         return answer;
//     }
// }

// class Solution {
//     public int solution(int k, int[][] dungeons) {
//         int answer = 0;
        
//         // (1) 정렬
//         for (int i=1; i<dungeons.length; i++) {
//             for (int j=0; j<dungeons.length-i; j++) {
                
//                 if (dungeons[j][0] == dungeons[j+1][0]) {
//                     if (dungeons[j][1] > dungeons[j+1][1]) {
//                         int[] temp = dungeons[j];
//                         dungeons[j] = dungeons[j+1];
//                         dungeons[j+1] = temp;
//                     }
//                 }
                
//                 if (dungeons[j][0] < dungeons[j+1][0]) {
//                     int[] temp = dungeons[j];
//                     dungeons[j] = dungeons[j+1];
//                     dungeons[j+1] = temp;
//                 }
//             }
//         }
        
//         for (int[] d : dungeons) {
//             System.out.println(d[0]);
//         }
        
//         // 앞에서부터 탐색
//         int index = 0;
        
//         while (k > 0 && index < dungeons.length) {
//             if (k >= dungeons[index][0]) {
//                 answer++;
//                 k -= dungeons[index][1];
//                 index++;
//                 System.out.println(k);
//                 continue;
//             }
//             index++;
//         }
        
//         return answer;
//     }
// }

class Solution {
    public static int answer = 0;
    public static int sol = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        perm(dungeons, new boolean[dungeons.length], 0, k, false);
        
        return answer;
    }
    
    public static void perm (int[][] arr, boolean[] visited, int depth, int k, boolean ok) {
        
        if (depth == arr.length) {
            if (sol > answer) {
                answer = sol;
            }
            
            return;
        }
        
        for (int i=0; i<arr.length; i++) {
            
            if (visited[i] != true) {
                visited[i] = true;
                
                if (k >= arr[i][0]) {
                    k -= arr[i][1];
                    sol++;
                    ok = true;
                }
                else {
                    ok = false;
                }
                
                perm(arr, visited, depth+1, k, ok);
                
                visited[i] = false;
                
                if (ok) {
                    k += arr[i][1];
                    sol--;
                }
            }
        }
    }
}

/*
조건 (1) 최소 필요 피로도 : 탐험 시작을 위해 요구되는 피로도
조건 (2) 소모 피로도 : 탐험을 마쳤을 때 소모됨
조건 (3) 하루에 한 번씩 탐색
조건 (4) 최대한 많이 탐험하려 함

주어진 값 :
(1) 피로도
(2) 던전별 최소 필요 피로도, 소모 피로도가 담긴 2차원 배열

풀이 방법
(1) 소모 피로도가 낮은 순서대로 탐험 -> 완전 실패
배열을 다 돌거나, 피로도가 0 이하가 되면 stop
(2) 최소 필요 피로도가 큰순서대로 탐험 -> 완전 실패
(3) 시작 위치를 다르게 하면서 최대 탐색을 찾는다.
visited 배열을 이용한 순열을 사용하면 좋을 듯!

point
2차원 배열을 특정 원소를 기준으로 정렬 (x)
*/