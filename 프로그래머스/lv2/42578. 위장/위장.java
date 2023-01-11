// // 풀이 (1) : 조합 활용
// import java.util.Map;
// import java.util.Set;
// import java.util.HashMap;

// class Solution {
//     public static int[] counts;
//     public static int answer = 0;
    
//     public int solution(String[][] clothes) {
        
//         // Map 생성
//         Map<String, Integer> map = new HashMap<>();
        
//         // 배열 분리
//         for (String[] clothe : clothes) {
//             String type = clothe[1];
            
//             // map 에 삽입
//             int count = 0;
//             if (map.containsKey(type)) {
//                 count = map.get(type);
//             }
//             map.put(type, ++count);
//         }
        
//         // // 정상적으로 담겼는지 확인
//         // System.out.println(map.entrySet());
        
//         // 경우의 수 확인 (1)
//         String[] types = map.keySet().toArray(new String[map.size()]);
//         counts = new int[map.size()];
        
//         for (int i=0; i<types.length; i++) {
//             counts[i] = map.get(types[i]);
//         }
//         // 경우의 수 확인 (2) 조합
//         for (int r=1; r <= counts.length; r++) {
//              Comb(new boolean[counts.length], 0, r, 1);
            
//             System.out.println(r);
//         }
//         return answer;
//     }
    
//     // 조합
//     public static void Comb (boolean[] visited, int start, int r, int total) {
//         if (r==0) {
//             answer += total;
//             return;
//         }
//         for (int i=start; i<counts.length; i++) {
//             // 방문
//             visited[i] = true;
//             total *= counts[i];
//             // 재귀
//             Comb(visited, i+1, r-1, total);
//             // 복구
//             total /= counts[i];
//             visited[i] = false;
//         }
//     }
// }
// /*
// 풀이 방법
// (1) 변수
// a) Map -> key : (String) 종류 / value : (int) 개수
// (2) 종류 파악 -> key
// a) split("_") 수행
//     가) 첫번째 원소 : 이름
//     나) 두번쨰 원소 : 종류
// b) a-나) 의 종류가 key 에 있는지 확인 (if 문)
//     가) true : 개수 ++ 해서 업데이트
//     나) false : 개수 1로 해서 추가 (add)
// (3) 경우의 수 환산
// a) value set 반환
// b) max 값 확인
// c) 1-max 까지 경우의 수 확인
//     ex) 모자 : 2개, 선글라스 : 1개, 바지 2개
//         가) max : 2개
//         나) 1개의 경우 : 2 + 1 + 2 = 5
//         다) 2개의 경우 : 2 * 1 + 2 * 2 + 1 * 2 = 8
//     ➡️ 조합으로 가야한다. / 완성될 때 마다 곱을 answer 에 더하는 방식
// */

// 풀이 (2) : 조합을 쓰지 않는 방식

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // Map 생성
        Map<String, Integer> map = new HashMap<>();
        
        // 배열 분리
        for (String[] clothe : clothes) {
            String type = clothe[1];
            
//             // map 에 삽입 : 방법 (1)
//             int count = 0;
//             if (map.containsKey(type)) {
//                 count = map.get(type);
//             }
//             map.put(type, ++count);
            
//             for (String[] clothe : clothes) {
//             String type = clothe[1];

            // map 에 삽입 : 방법 (2)
            int count = map.getOrDefault(type, 0);

            map.put(type, ++count);
        }
        
        
        // 경우의 수 확인 (1)
        String[] types = map.keySet().toArray(new String[map.size()]);
        int[] counts = new int[map.size()];
        
        for (int i=0; i<types.length; i++) {
            counts[i] = map.get(types[i]);
        }
        
        // 경우의 수 확인 (2)
        for (int n : counts) {
            answer *= n+1;
        }
        
        return --answer;
    }
}
/*
Point : 조합을 사용하지 않아야함
(각 옷 개수 + 안입는 경우) 를 다 곱하고 마지막에 -1 (모두 안입는 경우)
ex) 모자 2개 & 선글라스 1개
=> (2+1) * (1*1) -1 = 5
*/