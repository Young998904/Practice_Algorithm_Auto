class Solution {
    public static int[][] answer;
    public static int cnt = 0;
    public int[][] solution(int n) {
        // 배열 초기화
        int total = (int) Math.pow(2, n) - 1;
        answer = new int[total][2];
        
        // 1번에서 3번 원판으로 이동
        hanoi(n, 1, 3);
                
        return answer;
    }
    /*
    int num : 이동해야할 원판의 개수
    int start : 시작 기둥 번호
    int end : 도착 기둥 번호
    */
    public static void hanoi(int num, int start, int end) {
        if (num == 1) { // 옮겨야할 원판이 1개 인 경우 : start, end 삽입 후 리턴
            answer[cnt][0] = start;
            answer[cnt][1] = end;
            cnt++;
            return;
        }
        // 어느 기둥으로 이동할지 결정
        int sum = start + end;
        int left = 0;
        
        switch (sum) {
            case 3:
                left = 3;
                break;
            case 4:
                left = 2;
                break;
            case 5:
                left = 1;
                break;
        }
        
        // 원판 이동 순서 (1) : 마지막 원판을 제외한 나머지 원판을 목표 기둥 외 나머지로 이동
        hanoi(num -1, start, left);
        // 원판 이동 순서 (2) : 마지막 원판을 목표한 위치로 이동
        hanoi(1, start, end);
        // 원판 이동 순서 (3) : 나머지 원판을 목표 위치로 이동
        hanoi(num -1, left, end);
    }
}