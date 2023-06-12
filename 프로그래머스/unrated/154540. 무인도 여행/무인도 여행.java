import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    // 정답을 담기위한 리스트
    public static ArrayList<ArrayList<Dot>> route = new ArrayList<>();
    public static boolean[][] visited;
    public static String[][] map;
    public static int sum;
    public static int cnt;
    public static int n;
    public static int m;
    
    public int[] solution(String[] maps) {
        // n * m 형태의 사각형이라고 할 때
        n = maps.length;
        m = maps[0].length();
        // visited 배열 초기화
        visited = new boolean[n][m];
        // 관련 변수 초기화
        sum = 0;
        cnt = 0;
        // map 배열 초기화
        map = new String[n][m];
        for (int i=0; i<n; i++) {
            map[i] = maps[i].split("");
        }
        // // 확인
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<m; j++) {
        //         System.out.println(map[i][j]);
        //     }
        // }
        
       // 전체 탐색
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (visited[i][j] || map[i][j].equals("X")) continue;

                route.add(new ArrayList<>());

                search(i,j);

                cnt++;
            }
        }
        
        // 방문 값 구하기
        int[] answer;
        
        if (cnt == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        answer = new int[cnt];
        int sum = 0;

        for (int i=0; i<route.size(); i++) {
            for (Dot d : route.get(i)) {
                sum += Integer.parseInt(map[d.x][d.y]);
            }
            answer[i] = sum;
            sum = 0;
        }

        Arrays.sort(answer);
        
        return answer;
    }
    public static void search(int x, int y) {
        // 리턴하는 각종 조건
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (visited[x][y]) return;
        if (map[x][y].equals("X")) {
            visited[x][y] = true;
            return;
        }
        
        // 추가
        visited[x][y] = true;
        route.get(cnt).add(new Dot(x, y));
        
        // 상하좌우 이동
        search(x-1, y);
        search(x+1, y);
        search(x, y-1);
        search(x, y+1);
    }
}
class Dot {
    int x;
    int y;
    
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}