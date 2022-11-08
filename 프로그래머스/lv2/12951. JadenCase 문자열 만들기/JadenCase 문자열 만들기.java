import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        int upperCase = 'A' - 'a';

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.equals(" ")) {
                sb.append(str);
                continue;
            }
            char c = str.charAt(0);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c + upperCase));
            }
            else sb.append(c);
            str = str.toLowerCase();
            for (int i=1; i<str.length(); i++) {
                sb.append(str.charAt(i));
            }
        }

        answer = sb.toString();
        return answer;
    }
} 