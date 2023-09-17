import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static int[] arrA;
    public static int[] arrB;
    
    public ArrayList<Integer> divA = new ArrayList<>();
    public ArrayList<Integer> divB = new ArrayList<>();
    
    public int solution(int[] arrayA, int[] arrayB) {
        arrA = arrayA;
        arrB = arrayB;
        
        int answer = 0;
        
        // arrA 에서 확인
        int maxA = Integer.MAX_VALUE;
        
        for (int i=0; i<arrA.length; i++) {
            maxA = Math.min(maxA, arrA[i]);
        }
        
        // System.out.printf("철수 카드 중 제일 작은 값 : %d \n", maxA);
        
        divA = addDiv(maxA);
        
        Collections.sort(divA);
        
        // System.out.printf("철수 카드의 약수들 : ");
        // for (int n : divA) {
        //     System.out.printf("%d ", n);
        // }
        // System.out.println();
        
        int lastA = divA.lastIndexOf(maxA); // maxA 값이 배열의 마지막 값
        
        
        int numA = 0;
        for (int i=lastA; i>=1; i--) { // 1은 확인할 필요 없음
            numA = divA.get(i);
            
            if (!checkArrA(numA, true)) continue;
            if (!checkArrB(numA, false)) continue;
            
            // System.out.printf("철수 카드 중 양의 정수 a : %d \n", numA);
            
            answer = Math.max(answer, numA);
            break;
        }
        
        // System.out.printf("철수 카드 탐색 후 결과 : %d \n\n", answer);
        
        // arrB 에서 확인
        int maxB = Integer.MAX_VALUE;
        
        for (int i=0; i<arrB.length; i++) {
            maxB = Math.min(maxB, arrB[i]);
        }
        
        // System.out.printf("영희 카드 중 제일 작은 값 : %d \n", maxB);
        
        divB = addDiv(maxB);
        
        Collections.sort(divB);
        
        // System.out.printf("영희 카드의 약수들 : ");
        // for (int n : divB) {
        //     System.out.printf("%d ", n);
        // }
        // System.out.println();
        
        int lastB = divB.lastIndexOf(maxB); // maxA 값이 배열의 마지막 값
        
        int numB = 0;
        for (int i=lastB; i>=1; i--) { // 1은 확인할 필요 없음
            numB = divB.get(i);
            if (!checkArrA(numB, false)) continue;
            if (!checkArrB(numB, true)) continue;
           
            // System.out.printf("영희 카드 중 양의 정수 a : %d \n", numB);
            
            answer = Math.max(answer, numB);
            break;
        }
        
        // System.out.printf("영희 카드 탐색 후 결과 : %d \n\n", answer);
        
        return answer;
    }
    
    public static ArrayList<Integer> addDiv(int num) {
        ArrayList<Integer> divs = new ArrayList<>();
        
        for (int i=num; i>=(int) Math.sqrt(num); i--) {
            // 제곱근 확인
            if (num / i == i && num % i == 0) divs.add(i);
            
            // 나머지 ex) num = 18 / i = 6 인 경우
            if (num % i == 0) {
                divs.add(i); // 6 추가
                divs.add(num / i); // 3 추가
            }
        }
        
        return divs;
    }
    
    public static boolean checkArrA (int divisor, boolean type) {
        if (type) { // true 이면 나눠지는지 확인
            for (int i=0; i<arrA.length; i++) {
                if (arrA[i] % divisor != 0) return false;
            }
        }
        else { // false 이면 안나눠지는지 확인
            for (int i=0; i<arrA.length; i++) {
                if (arrA[i] % divisor == 0) return false;
            }
        }
        
        return true;
    }
    
    public static boolean checkArrB (int divisor, boolean type) {
        if (type) { // true 이면 나눠지는지 확인
            for (int i=0; i<arrB.length; i++) {
                if (arrB[i] % divisor != 0) return false;
            }
        }
        else { // false 이면 안나눠지는지 확인
            for (int i=0; i<arrB.length; i++) {
                if (arrB[i] % divisor == 0) return false;
            }
        }
        return true;
    }
}