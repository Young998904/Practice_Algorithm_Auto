class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        
        int max = 0;
        for (int i=0; i<len; i++) {
            if (max < topping[i]) {
                max = topping[i];
            }
        }
        
        // boolean 배열 생성
        boolean[] ltrCheck = new boolean[max];
        boolean[] rtlCheck = new boolean[max];
        // int 배열 생성
        int[] ltrCnt = new int[len];
        int[] rtlCnt = new int[len];
        
        // 초기화
        ltrCnt[0] = 1;
        ltrCheck[topping[0]-1] = true;
        
        rtlCnt[len-1] = 1;
        rtlCheck[topping[len-1]-1] = true;
        
        int tmp = 0;
        
        // 좌 ➡️ 우 탐색
        for (int i=1; i<len; i++) {
            tmp = topping[i];
            
            if (ltrCheck[tmp-1]) {
                ltrCnt[i] = ltrCnt[i-1];
                continue;
            }
            ltrCheck[tmp-1] = true;
            ltrCnt[i] = ltrCnt[i-1]+1;
        }
        // 우 ➡️ 좌 탐색
        for (int i=len-2; i>-1; i--) {
            tmp = topping[i];
            
            if (rtlCheck[tmp-1]) {
                rtlCnt[i] = rtlCnt[i+1];
                continue;
            }
            rtlCheck[tmp-1] = true;
            rtlCnt[i] = rtlCnt[i+1]+1;
        }
        
//         // 탐색 결과 확인
//         for (int n : ltrCnt) {
//             System.out.printf("%d, ", n);
//         }
//         System.out.println();
        
//         for (int n : rtlCnt) {
//             System.out.printf("%d, ", n);
//         }
//         System.out.println();
        
        // 케이크 자르기
        for (int i=0; i<len-1; i++) {
            if (ltrCnt[i] == rtlCnt[i+1]) {
                answer++;
            }
        }
        
        return answer;
    }
}

/*
keypoint ➡️ 먹은 토핑의 수가 같아야함

완탐? ➡️ stop 포인트가 index 1 부터 n-1 까지 가능 해당 모든 경우의 수를 확인하면서 조건에 부합하는지 확인해야함
확인방법? ➡️ 좌로 왔을때 종류의 수, 우로 왔을 때 종류의 수를 확인

ex) 입출력 예 1 의 경우 : [1, 2, 1, 3, 1, 4, 1, 2]

① 좌 ➡️ 우 [1, 2, 2, 3, 3, 4, 4, 4]
② 우 ➡️ 좌 [4, 4, 4, 4, 3, 3, 2, 1]

따라서 좌우 개수가 같은 stop 포인트 index 3/4 와 4 / 5
즉 [1, 2, 1, 3], [1, 4, 1, 2] 또는 [1, 2, 1, 3, 1], [4, 1, 2] 가 가능

[1, 2, 3, 3, 4]
[4, 3, 3, 2, 1]
*/