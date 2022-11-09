class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        
        // while (!s.equals("1")) {
        //     for (int i=0; i<s.length(); i++) {
        //         if (s.charAt(i) == '0') {
        //             answer[1]++;
        //         }
        //     }
        //     s = Integer.toBinaryString(s.replace("0", "").length());
        //     answer[0]++;
        // }
        
        while (!s.equals("1")) {
            int before = s.length();
            String after = s.replace("0", "");
            answer[1] += before - after.length();
                
            s = Integer.toBinaryString(after.length());
            answer[0]++;
            
        }
        
        return answer;
    }
}