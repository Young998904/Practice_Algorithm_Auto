class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        // 결과를 담기 위한 인접행렬
        int[][] result = new int[n][n];
        
        // results 배열값 담기
        for (int[] r : results) {
            result[r[0]-1][r[1]-1] = 1;
        }
        
        // Floyd-Washall Algorithm 적용
//         // 방법 ①
//         for(int i=0; i<n; i++) {
//             for (int j=0; j<n; j++) {
//                 if (result[i][j] == 1) {
//                     for (int k=0; k<n; k++) {
//                         if(result[j][k] == 1) {
//                             result[i][k] = 1;
//                         }
//                     }
//                 }
//             }
//         }
//         // 방법 ② : 방법 ① 과 논리적으로는 같지만 좀 더 Floyd-Washall 다움
//         for(int i=0; i<n; i++) {
//             for (int j=0; j<n; j++) {
//                 if (i==j || result[i][j] == 1) continue;
//                 for (int k=0; k<n; k++) {
//                     if (result[i][k] == 1 && result[k][j] == 1) result[i][j] = 1;
//                 }
//             }
//         }
        
//         // for (int i=0; i<n; i++) {
//         //     for (int j=0; j<n; j++) {
//         //         for (int k=0; k<n; k++) {
//         //             if (result[i][k] == 1 && result[k][j] ==1) {
//         //                 result[i][j] =1;
//         //             }
//         //         }
//         //     }
//         // }
        // 중간 노드를 반복문의 처음에 배치
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (i == j) continue;
                    if (result[i][k] == 1 && result[k][j] == 1) {
                        result[i][j] = 1;
                    }
                }
            }
        }
        
        // // 알고리즘 적용 결과 확인
        // for(int[] r : result) {
        //     for (int i=0; i<n; i++) {
        //         System.out.print(r[i]);
        //     }
        //     System.out.println();
        // }
        
        int cnt = 0;
        
        // 순위 확정 선수 수 도출
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==j) continue;
                if (result[i][j] == 1 || result[j][i] == 1) cnt++;
            }
            // 결과를 아는 경기 수가 전체 선수의 수-1 과 같으면 순위 확정
            // ex) 선수가 5명인 경우 한 선수에 대해 4경기에 대한 결과를 모두 알아야 순위 확정
            if (cnt == n-1) answer++;
            cnt=0;
        }
        
        return answer;
    }
}
/*
예시) [[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]
초기 형태
[0,1,0,0,0]
[0,0,0,0,1]
[0,1,0,0,0]
[0,1,1,0,0]
[0,0,0,0,0]

알고리즘 적용 후 형태
[0,1,0,0,1]
[0,0,0,0,1]
[0,1,0,0,1]
[0,1,1,0,1]
[0,0,0,0,0]
*/