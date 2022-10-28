class Solution {
    public int[] solution(long n) {
        String len = Long.toString(n);
        
        int[] answer = new int[len.length()];
        int index = 0;
        
        while (n > 0) {
            answer[index] = (int) (n % 10);
            n = n / 10;
            index ++;
        }
        
        return answer;
    }
}