// 방법 (1) 단순 반복문 : 정확성 (통과) / 효율성 (실패) / O(n2)

// import java.util.ArrayList;

// class Price {
//     int price;
//     int time;
//     boolean done;
    
//     public Price (int price) {
//         this.price = price;
//         this.time = 0;
//         this.done = false;
//     }
    
//     public void plus () {
//         this.time++;
//     }
    
//     public void isDone() {
//         this.time++;
//         this.done = true;
//     }
// }

// class Solution {
//     public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
        
//         ArrayList<Price> arr = new ArrayList<>();
        
//         for (int price : prices) {
//             // System.out.println("현재 주식 : " + price);
//             for (Price p : arr) {
//                 if (p.done) continue;
//                 // System.out.println("비교할 주식 : " + p.price);
//                 if (price >= p.price) p.plus();
//                 else p.isDone();
//             }
//             arr.add(new Price(price));
//         }
        
//         for (int i=0; i<prices.length; i++) {
//             answer[i] = arr.get(i).time;
//         }
        
//         return answer;
//     }
// }

// 방법 (2)
import java.util.Stack;

class Price {
    int idx;
    int price;
    
    public Price (int idx, int price) {
        this.idx = idx;
        this.price = price;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Price> stack = new Stack<>();
        
        // (1)
        int time = 0;
        
        for (int i=0; i<prices.length; i++) {
            Price p = new Price(i, prices[i]);
            
            if (stack.isEmpty()) {
                stack.push(p);
                time++;
                // System.out.printf("%d번 : %d / 스택에 추가 (time : %d)\n", p.idx, p.price, time);
                continue;
            }
            
            if (stack.peek().price > p.price) {
                while(!stack.isEmpty() && stack.peek().price > p.price) {
                    Price _p = stack.pop();
                    answer[_p.idx] = time - _p.idx;
                    // System.out.printf("%d번 : %d / 정답에 넣음 (time : %d)\n", _p.idx, _p.price, time);
                }
            }
            
            stack.add(p);
            
            time++;
        }
        
        // (2)
        time--;
        while (!stack.isEmpty()) {
            Price _p = stack.pop();
            answer[_p.idx] = time - _p.idx;
            // System.out.printf("%d번 : %d / 정답에 넣음 (time : %d)\n", _p.idx, _p.price, time);
        }
        
        return answer;
    }
}