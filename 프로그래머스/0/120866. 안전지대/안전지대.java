class Solution {
    public static boolean[][] isDanger;
    public static int[][] board_;
    public int solution(int[][] board) {
        board_ = board;
        
        int x = board[0].length; // 가로
        int y = board.length; // 세로
        
        int total = x*y; // 전체 개수
        
        isDanger = new boolean[y][x]; // 초기에는 모두 false
        
        int num = 0;
        for (int i=0; i<y; i++) {
            for (int j=0; j<x; j++) {
                num = board[i][j];
                
                if(num == 1) total -= toggle(i, j);
                
            }
        }
        
        return total;
    }
    public static int toggle (int i, int j) {
        int cnt = 0;
        
        int x_start = j-1 >=0 ? j-1 : 0;
        int x_end = j+1 < board_[0].length ? j+1 : board_[0].length-1;
        int y_start = i-1 >= 0 ? i-1 : 0;
        int y_end = i+1 < board_.length ? i+1 : board_.length-1;
        
        for (int y=y_start; y<=y_end; y++) {
            for (int x=x_start; x<= x_end; x++) {
                if (!isDanger[y][x]) {
                    isDanger[y][x] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
/*
1. boolean[] 을 만든다
2. 전체를 돌면서 1 이 나타나면 위험지대로 만드는 함수를 실행
3. 전체의 false 개수를 센다
*/