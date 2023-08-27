// // 시도 (1) 반례 : 75 -> 8

// class Solution {
//     public static int n;
//     public static int answer;
//     public int solution(int storey) {
//         answer = storey;
//         n = Integer.toString(storey).length(); // 자리수 확인
        
//         binary(storey, 1, 0);
        
//         return answer;
//     }
//     public static void binary(int value, int size, int cnt) {
//         System.out.printf("%d , %d, %d \n", value, size, cnt);

//         if (cnt > answer) return;
        
//         if (size == n) { // 마지막 자리수
//             cnt += (int) (value / Math.pow(10, Integer.toString(value).length()-1));
//             answer = Math.min(answer, cnt);
//             return;
//         }
        
//         // n 자리수 값 구하기
//         String number = Integer.toString(value);
//         int num = number.charAt(n-size) - 48;
        
//         if (num == 0) {
//             binary(value, size+1, cnt);
//         }
//         else {
//             int addNumA = num * (int) Math.pow(10, size-1);
//             int addNumB = (int) Math.pow(10, size) - addNumA;
//             // 이분할
//             binary(value-addNumA, size+1, cnt+num);
//             binary(value+addNumB, size+1, cnt+10-num);
//         }
        
//         return;
//     }
// }

// 시도 (2) 반례 : 75 -> 8 해결

class Solution {
    public static int n;
    public static int answer;
    public int solution(int storey) {
        answer = storey;
        n = Integer.toString(storey).length(); // 자리수 확인
        
        binary(storey, 1, 0);
        
        return answer;
    }
    public static void binary(int value, int size, int cnt) {
        System.out.printf("%d , %d, %d \n", value, size, cnt);

        if (cnt > answer) return; // 속도
        
        if (size == n) { // 마지막 자리수
            int last = (int) (value / Math.pow(10, Integer.toString(value).length()-1));
            
            int result = Math.min(cnt + last, cnt+(10-last) +1);
            answer = Math.min(answer, result); // min 값 갱신
            return;
        }
        
        // n 자리수 값 구하기
        String number = Integer.toString(value);
        int num = number.charAt(n-size) - 48;
        
        if (num == 0) {
            binary(value, size+1, cnt);
        }
        else {
            int addNumA = num * (int) Math.pow(10, size-1); // 내려가는 경우
            
            int addNumB = (int) Math.pow(10, size) - addNumA; // 올라가는 경우
            // 이분할
            binary(value-addNumA, size+1, cnt+num); // 내려
            binary(value+addNumB, size+1, cnt+10-num); // 올라
        }
        
        return;
    }
}