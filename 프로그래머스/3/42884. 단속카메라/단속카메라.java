import java.util.PriorityQueue;

class Car implements Comparable<Car> {
    int start;
    int end;
    
    public Car (int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Car other) {        
        return this.end - other.end;
    }
}

class Solution {
    public int solution(int[][] routes) {    
        PriorityQueue<Car> pq = new PriorityQueue<>();
        
        for (int[] route : routes) {
            pq.add(new Car(route[0], route[1]));
        }
        
//         // // 주의! : 이 방식은 pq 에 담겨있는 순서대로 나오지 않음
//         // for (Car car : pq) {
//         //     System.out.printf("%d / %d \n", car.start, car.end);
//         // }
        
        
//         // pq 에 담겨있는 순서대로 출력하는 방법
//         while (!pq.isEmpty()) {
//             Car car = pq.poll();  // pq에서 요소를 제거하면서 출력
//             System.out.printf("%d / %d \n", car.start, car.end);
//         }
        
        Car car = pq.poll();
        // System.out.printf("%d / %d\n", car.start, car.end);
        int answer = 1;
        
        int camIdx = car.end;
        // System.out.printf("%d 에 cctv 설치\n", camIdx);
        
        while (!pq.isEmpty()) {
            car = pq.poll();
            // System.out.printf("%d / %d\n", car.start, car.end);
            
            if (car.start <= camIdx) continue;
            
            answer++;
            camIdx = car.end;
            // System.out.printf("%d 에 cctv 설치\n", camIdx);
        }
        
        return answer;
    }
}

/*
- 조건
(1) 단속 카메라를 한 번은 만나야함
(2) 최소 카메라 개수

[[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
A : [-20,-15]
B : [-14,-5]
C : [-18,-13]
D : [-5,-3]]

A C A* B C* D&B* D*

- 풀이
(1) 나가는 것이 중요하므로 종료가 빠른 순
(2) PriorityQueue 에 담기
(3) 차가 모두 지나갈 때 까지 마지막 cctv 의 지점을 저장하면서 진행
    -> 무조건 차의 맨 끝을 cctv 지점으로 설정
        -> 다음 차의 시작이 cctv 지점 전이면 다음 차를 확인
        -> 다음 차의 시작이 cctv 지점 다음이면 해당 차량의 마지막을 새로운 cctv 지점으로 설정

*/