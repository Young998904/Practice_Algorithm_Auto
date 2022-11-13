import java.util.Collections;
import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[arr.length-1];
        
        for (int i=arr.length-2; i>-0; i--) {
            int tmp = arr[i];
            if (answer % tmp == 0) {
                continue;
            }
            for (int j=2; ;j++) {
                int check = answer * j;
                if (check % tmp == 0) {
                    answer = check;
                    break;
                }
            }
        }
        
        return answer;
    }
}
/*
1. 역순 정렬, 제일 큰 수가 임시 최소 공배수
2. 하나씩 넘어가면서 최소 공배수 구함
2-(1) 확인하는 수가 현재 최소 공배수의 약수인 경우 -> 현재 상태 유지
2-(2) 그렇지 않은 경우 -> 현재 최소 공배수가 나눠질 때까지 배수를 구함
*/