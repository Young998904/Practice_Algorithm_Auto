// class Solution {
//     public long[] solution(long[] numbers) {
//         long[] answer = new long[numbers.length];
        
//         for (int i=0; i<numbers.length; i++) {
//             answer[i] = min(numbers[i]);
//         }
        
//         return answer;
//     }
    
//     public static long min (long number) {
//         int numBitCnt = Long.bitCount(number);
        
//         for (long minVal=number+1; ; minVal++) {
//             long xor = number ^ minVal;
//             int xorBitCnt 
//             // int minValBitCnt = Long.bitCount(minVal);
//             // System.out.printf("%d : %d개 \n", minVal, minValBitCnt);
//             // if (Math.abs(numBitCnt-minValBitCnt) <= 2) {
//             //     return minVal;
//             // }
//         }
//     }
// }

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            // (1) 짝수인 경우 ➡️ +1 해서 정답 추가
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }

            String n = Long.toString(numbers[i], 2); // 2진법으로 변환

            // (2)-1 : 홀수이면서 1로만
            if(!n.contains("0")) { // String 2번째 자리에 0 삽입
                String temp = n.substring(0, 1) + "0" + n.substring(1);
                // 10진수로 변환 후 answer 배열에 삽입
                answer[i] = Long.parseLong(temp, 2); // 2진법 문자열을 long 으로 변환 후 저장
                
            } else {
                // (2)-2 : 홀수이면서 0이 있는 경우
                // 마지막으로 0이 나오는 인덱스 찾기 ➡️ 해당 문자열을 10으로 대체
                int idx = n.lastIndexOf("0");
                n = n.substring(0, idx) + "10" + n.substring(idx + 2);
                
                // 2진법 문자열을 long 으로 변환 후 저장
                answer[i] = Long.parseLong(n, 2);
            }
        }
        return answer;
    }
}
/*
1. 짝수
2 = 10 ➡️ 11
4 = 100 ➡️ 101

2. 홀수
7 = 111 ➡️ 1011
11 = 1011 ➡️ 1101
*/