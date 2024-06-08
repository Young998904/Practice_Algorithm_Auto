// class Solution {
//     // max 값들을 저장하기 위한 2차원 배열
//     public static int[][] dp;
//     // 정수 삼각형 길이 변수
//     public static int len;
//     public int solution(int[][] triangle) {
//         int answer = 0;
//         // 변수 생성
//         len = triangle.length;
//         System.out.println(len);
//         dp = new int[len][len];
        
//         // 초기화
//         dp[0][0] = triangle[0][0];
        
//         for (int depth=0; depth<len-1; depth++) {
//             for (int i=0; i<depth+1; i++) {
//             int value = dp[depth][i];
            
//             dp[depth+1][i] = Math.max(triangle[depth+1][i]+value, dp[depth+1][i]);
//             dp[depth+1][i+1] = Math.max(triangle[depth+1][i+1]+value, dp[depth+1][i+1]);
//             }
//         }
        
//         // 마지막 max 값 구하기
//         int max = 0;
//         for(int num : dp[triangle.length-1])
//             if(max<num) max = num;
        
//         return max;
//     }
// }

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        
        for (int i=1; i<N; i++) {
            for (int j=0; j<=i; j++) {
                // (1) 양끝에 해당할 경우
                if (j == 0) { // (1)-1 첫번째
                    triangle[i][j] += triangle[i-1][0];
                    continue;
                }
                else if(j == i) { // (1)-2 마지막
                    triangle[i][j] += triangle[i-1][j-1];
                    continue;
                }
                
                // (2) 나머지 중간값
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        // // 값 확인
        // for (int[] tri : triangle) {
        //     for (int n : tri) {
        //         System.out.printf("%d ", n);
        //     } 
        //     System.out.println();
        // }
        
        int max = -1;
        
        for (int num : triangle[N-1]) {
            max = Math.max(num, max);
        }
        return max;
    }
}

/*
풀이 방식
DP 를 이용한 방식으로 triangle 의 배열을 타고 내려가면서 각 줄을 갱신한다. 
이때, 좌우 합 중 Max 값으로 갱신하며, 마지막 줄에서 Max 값을 찾아 반환한다.
*/