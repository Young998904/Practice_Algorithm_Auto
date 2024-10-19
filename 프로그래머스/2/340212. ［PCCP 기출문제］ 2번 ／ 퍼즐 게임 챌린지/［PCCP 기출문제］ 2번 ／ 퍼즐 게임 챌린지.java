// 풀이 방법 : 이분 탐색
import java.util.Arrays;

class Solution {
    public static int[] _diffs;
    public static int[] _times;
    public static long _limit;
    public int solution(int[] diffs, int[] times, long limit) {
        _diffs = diffs.clone();
        _times = times.clone();
        _limit = limit;
        
        Arrays.sort(diffs);
        int left = diffs[0];
        int right = diffs[diffs.length-1];
        int mid = 0;
        int answer = right;
        
        while (left <= right) {
            
            mid = (left + right) / 2;
            // System.out.printf("설정 숙련도 : %d\n", mid);
            
            if (isSuccess(mid)) { // (1) 숙련도가 더 낮아져도 괜찮음
                // System.out.printf("숙련도 충분\n");
                right = mid-1;
                answer = Math.min(mid, answer);
            }
            else { // (2) 숙련도가 더 높아져야 함
                // System.out.printf("숙련도 부족\n");
                left = mid+1;
            }
            
            _limit = limit;
        }
        
        return answer;
    }
    public static boolean isSuccess (int level) {
        
        // 첫번째 문제의 난이도가 숙련도보다 높을 경우 앞으로 갈 문제가 없으므로 바로 false 리턴
        if (_diffs[0] > level) return false;
        
        for (int p=0; p<_diffs.length; p++) {
            int diff = _diffs[p];
            int time_cur = _times[p];
            // System.out.printf("문제 숙련도 : %d\n", diff);
            
            if (diff <= level) { // (1) diff < level
                _limit -= time_cur;
                // System.out.printf("잃은 시간 : %d\n", time_cur);
            }
            else { // (2) diff > level
                _limit -= ((diff-level)*(time_cur+_times[p-1]) + time_cur);
                // System.out.printf("잃은 시간 : %d\n", ((diff-level)*(time_cur+_times[p-1]) + time_cur));
            }
            
            if (_limit < 0) return false;
        }
        
        return true;
    }
}