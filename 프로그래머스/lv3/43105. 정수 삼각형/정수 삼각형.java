class Solution {
    // max 값들을 저장하기 위한 2차원 배열
    public static int[][] dp;
    // 정수 삼각형 길이 변수
    public static int len;
    public int solution(int[][] triangle) {
        int answer = 0;
        // 변수 생성
        len = triangle.length;
        System.out.println(len);
        dp = new int[len][len];
        
        // 초기화
        dp[0][0] = triangle[0][0];
        
        for (int depth=0; depth<len-1; depth++) {
            for (int i=0; i<depth+1; i++) {
            int value = dp[depth][i];
            
            dp[depth+1][i] = Math.max(triangle[depth+1][i]+value, dp[depth+1][i]);
            dp[depth+1][i+1] = Math.max(triangle[depth+1][i+1]+value, dp[depth+1][i+1]);
            }
        }
        
        // 마지막 max 값 구하기
        int max = 0;
        for(int num : dp[triangle.length-1])
            if(max<num) max = num;
        
        return max;
    }
}