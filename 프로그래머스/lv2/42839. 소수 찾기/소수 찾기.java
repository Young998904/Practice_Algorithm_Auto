import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static HashSet<Integer> answer = new HashSet<>();
    
    public int solution(String numbers) {
        
        // 1. 문자열을 쪼개서 숫자 배열로 담는다.
        String [] strNums = numbers.split(""); //["0", "1", "1"]
        
        // 2. 배열 sort (생략가능)
        Arrays.sort(strNums); //["0", "1", "1"]
        
        // 3. 소수 탐색 (순열 활용)
        for (int i=1; i<= strNums.length; i++) {
            perm(strNums, 0, strNums.length, i);
        }
        
        for (int num : answer) {
            System.out.println(num);
        }
        
        return answer.size();
    }
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void perm(String[] arr, int depth, int n, int r) {
        if (depth == r) {
            String number = "";
            for (int i=0; i<depth; i++) {
                number += arr[i];
            }
            int num = Integer.valueOf(number);
            
            if (isPrime(num)) {
                answer.add(num);
            }
            
            return;
        }
        for (int i=depth; i<n; i++) {
            swap(arr, depth, i); // 바꾸기
            perm(arr, depth+1, n, r);
            swap(arr, depth, i); // 원상 복구
        }
    }
    public static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    
}

/*
방식 (1) 문자열을 배열로 바꿔서
=> 생각해보니 subString 이 더 좋을 듯 => 그러면 완탐이 힘드네? (취소)
소수 : 2, 3, 5, 7, 11, 13, 15, 17, 19 ..
(1). 문자열을 쪼개서 배열로 담는다.
(2). 하나씩 확인하며 answer 값 올림
-> 소수를 담는 배열이 필요한가? => sort 를 해서 맨앞이 0 이면 index 1부터 시작
(3). 소수 판별 -> 범위를 지정해서 하는 방식이 불편하다고 느껴서 다시 생각
(4) 배열로 가능한 모든 경우의 수를 확인하려면 순열 필요
(5) 0 으로 인해 발생하는 문제 -> 발생 가능한 경우만큼 뺀다.

방식 (2) 문자열을 subString & valueOf 를 사용해서 확인한다. (취소)

최종 풀이방식
1. 문자열 -> 문자열 배열 (하나씩 쪼개기)
2. 순열 돌리면서 소수 판정

잘 모르겠는 부분
1. 0에 대한 처리
2. 중복에 대한 처리 -> HashSet
*/