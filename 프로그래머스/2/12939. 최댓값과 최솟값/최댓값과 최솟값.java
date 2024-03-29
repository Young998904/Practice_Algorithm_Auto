import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        System.out.printf("입력값 : " + s + "\n");
        
        String[] strList = s.split(" ");
        int[] numList = Arrays.stream(strList)
            .mapToInt(Integer::parseInt)
            .toArray();
        
        Arrays.sort(numList);
        
        answer += numList[0] + " " + numList[numList.length-1];
        
        System.out.printf("정답 : " + answer);
        
        return answer;
    }
}