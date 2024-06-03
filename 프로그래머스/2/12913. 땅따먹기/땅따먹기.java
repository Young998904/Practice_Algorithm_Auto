// // 규칙 : 같은 열을 연속해서 밟을 수 X
// // return : 얻을 수 있는 점수 최대값
// /*
// 최대값
// -> 탐욕법
// -> DP : 괜찮을 듯 (값을 가져오는 형태)...?
// -> DFS : 너무 완탐
// */
// class Solution {
//     public static int[][][] dp;
//     public static int[][] _land;
//     int solution(int[][] land) {
//         _land = land;
//         int N = land.length; // 행 (열은 4로 고정)
//         dp = new int[N][N][4]; // 3차원 배열 선언
        
//         int answer = 0;
        
//         for (int i=0; i<N; i++) {
//             answer = Math.max(answer, DP(0, N, i));
//         }

//         return answer;
//     }
    
//     /*
//     int startRow : 시작 행
//     int endRow : 종료 행
//     int startIdx : 시작 인덱스
//     */
//     public int[] findMax (int startRow, int endRow, int startIdx) {
//         int[] result = new int[2];
//         int max = dp[startRow][endRow][startIdx];
        
//         if (max == 0) { // 새로운 result 값 생성 및 반환        
//             for (int i=0; i<N; i++) {
//                 if (i == startIdx) continue;    
                
//                 if (_land[startRow][startIdx] + _land[endRow][i] > max)
//                 max = Math.max(max, _land[startRow][startIdx] + _land[endRow][i]);
//             }
//         }
//         else {
//             return max;
//         }
//     }
    
//     public int DP (int startRow, int endRow, int startIdx) {
        
//     }
// }

// /*
// (0, N, 0) = (0, 1, 0) + (1, N, a)
// (0, N, 1) = (0, 1, 1) + (1, N, b)
// (0, N, 2) = (0, 1, 2) + (1, N, c)
// (0, N, 3) = (0, 1, 3) + (1, N, d)

// (1, N, ?) = (1, 2, ?) + (2, N, ?)

// 저장해아할 값 -> x -> y + 들리면 안되는곳 (3차원 배열)
// */

// class Solution {
//     public static int[][] _land;
//     public static int[][][] dp;
//     int solution(int[][] land) {
//         int N = land.length;
//         dp = new int[N][N][4];
//         _land = land;
        
//         int answer = 0;
        
//         for (int i=0; i<4; i++) {
//             answer = Math.max(answer, dp(0, N, i));
//         }
//         return answer;
//     }
    
//     public static int dp (int startRow, int endRow, int startIdx) {
//         // startRow == endRow 일 경우 바로 land 값을 반환
//         if (startRow == endRow) return 0;
        
//         // 기존에 저장된 값이 있는 경우 해당 dp 값을 반환
//         if (dp[startRow][endRow][startIdx] != 0) return dp[startRow][endRow][startIdx];
        
//         int nextIdx = findMax(startRow, startRow+1, startIdx);
        
//         dp[startRow][endRow][startIdx] = dp(startRow, startRow+1, startIdx) + dp(startRow+1, endRow, nextIdx);
        
//         return dp[startRow][endRow][startIdx];
//     }
    
//     public static int findMax (int startRow, int endRow, int startIdx) {
//         int max = 0;
//         int val = 0;
//         int idx = 0;
        
//         for (int i=0; i<4; i++) {
//             if (i == startIdx) continue;
//             val = _land[startRow][startIdx]  + _land[endRow][i];
            
//             if (val > max) {
//                 max = val;
//                 idx = i;
//             }
//         }
        
//         dp[startRow][endRow][startIdx] = max;
        
//         return idx;
//     }
// }

// /*
// 1 2 3 5
// 5 6 7 8
// 4 3 2 1

// dp(0, 3, 0)

// findMax(0, 1, 0);
// nextIdx = 3
// dp[0, 1, 0] = 9

// dp[0][3][0] = dp(0, 1, 0) + dp(1, 3, 3);

// dp(1, 3, 3);

// findMax(1, 2, 3);
// */

/*
int[][] dp = new int[층][밝은 땅];
*/
class Solution {
    public static int[][] dp;
    public static int[][] _land;
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        dp = new int[N][4];
        _land = land;
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<4; j++) {
                update(i, j);
            }
        }
        
        // for (int[] _dp : dp) {
        //     for (int num : _dp) {
        //         System.out.printf("%d ", num);
        //     }
        //     System.out.println();
        // }
        
        for (int i=0; i<4; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }
        
        return answer;
    }
    public static void update(int i, int j) {
        if (i == 0) {
            dp[i][j] = _land[i][j];
            return;
        }
        
        for (int k=0; k<4; k++) {
            if (k == j) continue;
            
            dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + _land[i][j]);
        }
    }
}

/*
첫째줄부터 시작해서 마지막줄까지 dp 배열을 업데이트해서 마지막줄에서 Max 값을 확인하는 방식
*/