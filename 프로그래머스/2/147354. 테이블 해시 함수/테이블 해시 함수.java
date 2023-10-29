// // 풀이 (1)
// import java.util.Queue;
// import java.util.LinkedList;
// import java.util.Stack;

// // import java.util.BitSet;

// class Solution {
//     public static Stack<int[]> dataStack = new Stack<>();
//     public static Stack<int[]> stayStack = new Stack<>();
    
//     public int solution(int[][] data, int col, int row_begin, int row_end) {
//         int answer = 0;
        
//         // (1) 테이블 정렬 _ Stack 활용
//         dataStack.push(data[0]);
        
//         int[] top = new int[3];
        
//         for (int i=1; i < data.length; i++) {
//             int[] now = data[i];
            
//             while(!dataStack.isEmpty()) {
//                 top = dataStack.peek();
                
//                 // 수가 같은 경우 (첫번째로 위치 전환)
//                 if (top[col-1] == now[col-1]) {
                    
//                     if (top[0] > now[0]) {
//                         dataStack.add(now); // 위치 결정
//                         break;
//                     }
//                     stayStack.add(dataStack.pop());
//                     if (dataStack.isEmpty()) {
//                         dataStack.add(now); // 위치 결정
//                         break;
//                     }
//                     continue;
//                 }
                
//                 // 비교 시작
//                 if (top[col-1] < now[col-1]) {
//                     dataStack.add(now); // 위치 결정
//                   break;
//                 }
                
//                 stayStack.add(dataStack.pop());
//             }
            
//             // StayStack 에 있는 나머지 쌓기
//             while (!stayStack.isEmpty()) {
//                 dataStack.add(stayStack.pop());
//             }
//         }
        
//         // (2) 정리
//         int endNum = data.length-1;
        
//         while (!dataStack.isEmpty()) {
//             int[] one = dataStack.pop();
//             data[endNum--] = one;
//             // // 확인
//             // System.out.printf("%d %d %d \n", one[0], one[1], one[2]);
//         }
        
//         // // 확인
//         // for (int[] nn : data) {
//         //     System.out.printf("%d %d %d \n", nn[0], nn[1], nn[2]);
//         // }
        
//         // (3) S_i 값 연산 및 저장
//         // 배열 생성
//         int[] s = new int[row_end-row_begin+1];
//         int startNum = 0;
//         for (int i=row_begin-1; i<row_end; i++) {
//             s[startNum++] = data[i][0] % (i+1) + data[i][1] % (i+1) + data[i][2] % (i+1);
//         }
        
//         // // 확인
//         // for (int num : s) {
//         //     System.out.println(num);
//         // }
        
//         // (4) XOR 연산 수행 -> ?
//         for (int num : s) {
//             answer = answer ^ num;
//         }
        
//         return answer;
//     }
// }


// 풀이 (2)
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // (1) 테이블 정렬 _ Stream 활용
        List<int[]> dataSorted = Arrays.stream(data).sorted(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[col-1] == o2[col-1]) {
                        return o2[0] - o1[0];
                    }
                    return o1[col-1] - o2[col-1];
                }
            }
        ).collect(Collectors.toList());
        
        // // 정렬 확인
        // for (int[] nums : dataSorted) {
        //     System.out.printf("%d / %d / %d \n", nums[0], nums[1], nums[2]);
        // }
        
        // (2) S_i 연산 수행 및 XOR 연산 수행
        int S_i = 0;
        int lastIdx = data[0].length;
        int[] nums = new int[lastIdx];
        
        for (int i=row_begin-1; i<row_end; i++) {
            nums = dataSorted.get(i);
            
            S_i = 0;
            
            for (int j=0; j<lastIdx; j++) {
                S_i += nums[j] % (i+1);
            }
            // System.out.printf("S_%d : %d \n", i+1, S_i);
            answer ^= S_i;
        }
        
        return answer;
    }
}