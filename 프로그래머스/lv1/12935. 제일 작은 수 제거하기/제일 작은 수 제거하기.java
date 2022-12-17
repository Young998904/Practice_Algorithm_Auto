import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[] {-1};
        }
        
        int index = 0;
        
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < arr[index]) {
                index = i;
            }
        }
        
        int[] arr2 = new int[arr.length-1];
        
        int tmp = 0;
        
        for (int i=0; i<arr.length; i++) {
            if (i == index) {
                continue;
            }
            arr2[tmp++] = arr[i];
        }
        
        return arr2;
    }
}

// 제일 작은 수의 인덱스를 확인한 다음 새로운 배열을 만들어서 해당 인덱스만 넘어가서 넣는다.