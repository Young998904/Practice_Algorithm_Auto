import java.util.*;

class Point {
    int x,y;
    
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static int n;
    public static int m;
    public static String[] _board;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        _board = board;
        
        int[] dx = {-1, 1, 0, 0}; // 상하
        int[] dy = {0, 0, -1, 1}; // 좌우
        
        // (1) 시작점 찾기 ('R')
        Queue<Point> q = new LinkedList<>();
        int[][] cnt = new int[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i].charAt(j) == 'R') {
                    q.add(new Point(i, j));
                    cnt[i][j] = 1;
                    break;
                }
            }
        }
        
//         Point start = q.poll();
        
//         System.out.println(start.x);
//         System.out.println(start.y);
        
        // (2) 탐색
        int answer = -1;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            
            int x = p.x;
            int y = p.y;
            
            // System.out.printf("현재 위치 : %d, %d\n", x, y);
            
            // 목표 지점이면 정답 반환
            if (board[x].charAt(y) == 'G') {
                answer = cnt[x][y] - 1;
                break;
            }
            
            // 상하좌우 이동 및 좌표 추가
            for (int k=0; k<4; k++) {
                int _x = x + dx[k];
                int _y = y + dy[k];
                
                // 방향대로 끝까지 이동
                while (true) {                
                    if (inRange(_x, _y)) {
                        _x += dx[k];
                        _y += dy[k];
                    }
                    else {
                        _x -= dx[k];
                        _y -= dy[k];                    
                        break;
                    }
                }
                
                if (cnt[_x][_y] == 0) {
                    // System.out.printf("좌표 추가 : %d, %d\n", _x, _y);
                        
                    q.add(new Point(_x, _y));
                    cnt[_x][_y] = cnt[x][y] + 1;
                }
            }
        }
        
        return answer;
    }
    public static boolean inRange (int x, int y) {
        if (x>=0 && x<n && y>=0 && y<m && _board[x].charAt(y) != 'D') return true;
        
        return false;
    }
}