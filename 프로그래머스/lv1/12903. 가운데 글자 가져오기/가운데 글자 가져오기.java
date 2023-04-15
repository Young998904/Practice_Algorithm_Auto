class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int half = (s.length()+1) / 2;
        
        
        if (len % 2 == 0) {
            return s.substring(half-1, half+1);
        }
        
        return s.substring(half-1, half);
    }
}