import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            }
            n--;
            ans++;
        }
        
        return ans;
    }
}
/*
케이스 : 5
*2 로 5 불가 한 칸 앞으로 -1 -> 4
*2 로 4 가능 순간이동 /2 -> 2
*2 로 2 가능 순간이동 /2 -> 1
*2 로 1 불가 한 칸 앞으로 -1 -> 0
정답 => 2

케이스 : 6
6(0) -> 3(0) -> 2(1) -> 1(1) -> 0(2)
정답 => 2
*/