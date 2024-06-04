import java.util.Arrays;

class Solution {
    public static int[] _reserve;
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        _reserve = reserve;
        
        // 두 배열 정렬
        Arrays.sort(_reserve);
        Arrays.sort(lost);
        
        // 여분이 있는 동시에 잃어버린 경우에 대한 처리
        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<_reserve.length; j++) {
                if (lost[i] == _reserve[j]) { // 조건을 만족하는 경우 두 배열 값을 모두 -1 로 변경
                    lost[i] = -1; 
                    _reserve[j] = -1;
                }
            }
        }
        
        for (int findNum : lost) {
            
            if (findNum == -1) continue; // (1) 여벌이 있는 동시에 잃어버린 경우
            
            if (check(findNum-1)) continue; // (2) 작은 사이즈 부터 확인
            
            if (check(findNum+1)) continue; // (3) 작은 사이즈 없을 경우 큰사이즈 확인
            
            answer--; // (4) 둘 다 없을 경우 정답 1 감소 
        }
        return answer;
    }
    
    // 원하는 사이즈가 있는지 확인하는 함수
    public static boolean check(int needNum) {
        
        for (int i=0; i<_reserve.length; i++) {
            if (needNum == _reserve[i]) { // 원하는 사이즈가 있을 경우 해당 idx 값은 -1 로 변경 후 true 리턴
                _reserve[i] = -1;
                return true;
            }
        }
        
        return false; // 원하는 사이즈 없을 경우 false 리턴
    }
}

/*
- 조건
(1) 바로 앞번호나 뒷번호 학생에게만 빌려줄 수 있음
(2) 여벌이 있을 때 도난 당한건 무조건 1개 -> 자기만 있으므로 쉐어 불가

- 풀이 (max 를 까내려 가는 방식)
(1) lost 를 탐색 -> 해결을 못하면 max 를 마이너스
(2) 앞 뒤를 확인해서 둘 다 있으면 다음 사람을 위해 더 작은 사이즈 사용
*/