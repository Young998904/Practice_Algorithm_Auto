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