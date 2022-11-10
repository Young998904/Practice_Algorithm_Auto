class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int point = (brown - 4) / 2;
        int breakPoint = point % 2 == 0 ? point / 2 : point / 2 +1;
        int product = brown + yellow;
        
            for (int i = point-1; i>= breakPoint; i--) {
                int g = i+2;
                int s = point-i+2;
                if (g*s == product) {
                    answer[0] = g;
                    answer[1] = s;
                    
                    break;
                }
            }
        
        return answer;
    }
}