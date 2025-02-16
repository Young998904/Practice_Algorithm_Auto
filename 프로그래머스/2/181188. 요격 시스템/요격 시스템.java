// import java.util.Arrays;

// class Solution {
//     public int solution(int[][] targets) {
//         // 시작 시점 기준으로 정렬, 같다면 끝 시점 기준으로 정렬
//         Arrays.sort(targets, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        
//         int answer = 1;
//         int end = targets[0][1]; // 첫 번째 타겟의 끝 지점 기준으로 초기화
        
//         for (int i = 1; i < targets.length; i++) {
//             if (targets[i][0] < end) {
//                 // 겹치는 구간이 있으면 최소의 끝 지점으로 업데이트
//                 end = Math.min(end, targets[i][1]);
//             } else {
//                 // 새로운 요격이 필요하면 끝 지점 갱신 및 카운트 증가
//                 end = targets[i][1];
//                 answer++;
//             }
//         }
        
//         return answer;
//     }
// }

// // 시작 - 끝 [1,4] [3,7] [4,5] [4,8] [5, 12] [10, 14] [11, 13]

import java.util.PriorityQueue;

class Target implements Comparable<Target>{
    int s;
    int e;
    
    public Target (int s, int e) {
        this.s = s;
        this.e = e;
    }
    
    @Override
    public int compareTo(Target other) {
        if (this.s == other.s) return this.e - other.e;
        
        return this.s - other.s;
    }
}

class Solution {
    public int solution(int[][] targets) {
        
        // (1) 입력값 객체화해서 pq 에 정리
        PriorityQueue<Target> pq = new PriorityQueue<>();
        
        for (int[] target : targets) {
            pq.add(new Target(target[0], target[1]));
        }
        
        // // 정렬 확인
        // while (!pq.isEmpty()) {
        //     Target t = pq.poll();
        //     System.out.printf("%d, %d\n", t.s, t.e);
        // }
        
        // (2) 요격 진행
        
        int answer = 1;
        
        Target tmp = pq.poll();
        
        int start = tmp.s;
        int end = tmp.e;
        
        
        while (!pq.isEmpty()) {
            Target next = pq.poll();
            
            int _start = next.s;
            int _end = next.e;
            
            if (_start < end) {
                start = Math.max(start, _start);
                end = Math.min(end, _end);
            }
            else {
                // System.out.printf("%d 부터 %d 사이에 발사\n", start, end);
                start = _start;
                end = _end;
                answer++;
            }
        }
        
        return answer;
    }
}