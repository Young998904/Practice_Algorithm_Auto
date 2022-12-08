import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i] % divisor == 0) {
                count++;
                continue;
            }
            arr[i] = 0;
        }
        
        if (count == 0) {
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[count];
        
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            answer[--count] = arr[i];
        }
        
        Arrays.sort(answer);
        return answer;
    }
}