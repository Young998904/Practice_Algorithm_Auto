import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        
        // times 배열 오름차순 정렬
        Arrays.sort(times);
        
        long maxTime = (long) n * times[0];
        
        // 이분탐색 실행
        long left = 1;
        long right = maxTime+1;
        long minTime = maxTime;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            // System.out.printf("현재 시간 : %d\n", time[mid]);
            
            long cnt = 0;
            
            for (int i=0; i<times.length; i++) {
                cnt += mid / times[i];
                
                if (cnt > n) break;
                // System.out.printf("%d 더함\n", time[mid]/times[i]);
            }
            
            // System.out.printf("현재 minIdx 값 : %d\n", minIdx);
            
            if (cnt >= n) {
                // System.out.printf("cnt 가 %d 으로 더 크거나 같음\n", cnt);
                right = mid-1;
                minTime = Math.min(minTime, mid);
            }
            else {
                left = mid+1;
            }
            
            // System.out.printf("조정 후 minIdx 값 : %d\n", minIdx);
        }
        
        return minTime;
    }
}