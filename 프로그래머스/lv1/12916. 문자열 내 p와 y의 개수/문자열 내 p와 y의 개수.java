import java.lang.String;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt= 0;
        
        String str = s.toLowerCase();
        
        for (int i=0; i<str.length(); i++) {
            if ('p' == str.charAt(i)) {
                cnt++;
            }
            else if ('y' == str.charAt(i)) {
                cnt --;
            }
        }
        
        if (cnt == 0) {
            return answer;
        }
        
        return false;
    }
}