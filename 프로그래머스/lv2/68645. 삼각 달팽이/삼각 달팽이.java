class Solution {
    public static int[][] tri;
    public static int tmp = 1;
    public static int x = -1;
    public static int y = 0;
    
    public int[] solution(int n) {
        // 층 마다 숫자를 담을 배열
        tri = new int[n][n];
        
        // 이동 방향 확인
        boolean down = true;
        boolean right = false;
        boolean up = false;
        
        for (int i=n; i>0; i--) {
            if (down) {
                down(i);
                down = false;
                right = true;
                // System.out.printf("%d 번쨰 down \n", i);
            }
            else if (right) {
                right(i);
                right = false;
                up = true;
                // System.out.printf("%d 번쨰 right \n", i);
            }
            else if (up) {
                up(i);
                down = true;
                up = false;
                // System.out.printf("%d 번쨰 up \n", i);
            }
        }
        
        // for (int[] k : tri) {
        //     for (int kk : k) {
        //         System.out.printf("%d ", kk);
        //     }
        //     System.out.println();
        // }
        
        int idx = 0;
         int[] answer = new int[tmp-1];
        
        for (int m=0; m<n; m++) {
            for (int u=0; u<m+1; u++) {
                answer[idx++] = tri[m][u];
            }
        }
        
        return answer;
    }
    public static void down (int step) {
        for (int i=0; i<step; i++) {
            x++;      
            tri[x][y] = tmp;
            tmp ++;
        }
        return;
    }
    public static void right (int step) {
        for (int i=0; i<step; i++) {
            y++;
            tri[x][y] = tmp;
            tmp++;
        }
        return;
    }
    public static void up (int step) {
        for (int i=0; i<step; i++) {
            x--;
            y--;
            tri[x][y] = tmp;
            tmp++;
        }
        return;
    }
}