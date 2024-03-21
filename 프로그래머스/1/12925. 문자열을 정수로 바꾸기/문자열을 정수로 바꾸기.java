class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean isNegative = false;
        String str;
        
        if (s.charAt(0) == '-') {
            str = s.substring(1);
            isNegative = true;
        }
        else if (s.charAt(0) == '+') {
            str = s.substring(1);
        }
        else {
            str = s;
        }
        
        answer = Integer.parseInt(str);
        
        if (isNegative) {
            return answer * (-1);
        }
        
        return answer;
    }
}