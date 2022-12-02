class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        if (n == 1) return 0;
        
        while (n != 1) {
            if (answer > 500) {
                return -1;
            }
            if (n % 2 == 0) {
                n = n / 2;
                answer ++;
                continue;
            }
            n = n*3 +1;
            answer++;
        }
        return answer;
    }
}
// int 사용시 주의할 점 : int 의 범위를 벗어나지 않는지 확인해야함