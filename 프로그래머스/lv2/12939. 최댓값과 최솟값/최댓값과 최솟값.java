import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strList = s.split(" ");
        int[] numList = Arrays.stream(strList)
            .mapToInt(Integer::parseInt)
            .toArray();
        
        Arrays.sort(numList);
        
        answer += String.valueOf(numList[0]) + " " + numList[numList.length-1];
        
        return answer;
    }
}