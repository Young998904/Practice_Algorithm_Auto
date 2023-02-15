class Solution {
    // 1 과 0 의 개수
    public static int one = 0;
    public static int zero;
    public static int[][] Arr;
    
    public int[] solution(int[][] arr) {
        Arr = arr;
        
        // 크기
        int size = arr.length;
        
        // ① 전체를 탐색하며 1 과 0 의 개수 파악
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                one += arr[i][j];
            }
        }
        zero = (int) Math.pow(size,2) - one;
        
        // ② 탐색
        quad(0, 0, size);
        
        return new int[] {zero,one};
    }
    public static void quad(int x, int y, int limit) {
        // 첫번째 원소 확인
        int tmp = Arr[x][y];
        
        if (limit == 1) { // 마지막 한 칸까지 온 경우 : 바로 return (개수 변화 없음)
            return;
        }
        
        // 탐색
        for (int i=x; i<x+limit; i++) {
            for (int j=y; j<y+limit; j++) {                
                if (tmp != Arr[i][j]) { // 경우 ① : 압축에 실패할 경우 ➡️ 분할
                    limit = limit / 2;
                    quad(x, y, limit);
                    quad(x, y + limit, limit);
                    quad(x + limit, y, limit);
                    quad(x + limit, y+limit, limit);
                    return;
                }
            }
        }
        
        // 경우 ② : 압축에 성공한 경우 ➡️ 압축한 만큼 개수 제거
        if (tmp == 1) {
            one = one - ((int)Math.pow(limit, 2)-1);
            return;
        }
        zero = zero - ((int)Math.pow(limit, 2)-1);
        return;
    }    
}