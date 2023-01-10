// 방법(1) : 단순 배열을 통한 풀이
// import java.util.Arrays;
// import java.util.Comparator;
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         // 정렬
//         Arrays.sort(phone_book, new Comparator<String>() {
//             @Override
//             public int compare(String s1, String s2) {
//                 return s1.length() - s2.length();
//             }
//         });
        
//         // 탐색
//         for (int i=0; i<phone_book.length; i++) {
//             String pre = phone_book[i];
//             int preSize = pre.length();
//             for (int j=i+1; j<phone_book.length; j++) {
//                 String comp = phone_book[j];
//                 if (pre.equals(comp.substring(0, preSize))) {
//                     return false;
//                 }
//             }
//         }
//         return answer;
//     }
// }

// 방법 (2)
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // Set 생성 및 원소 추가
        Set<String> set = new HashSet<>();
        for (String str : phone_book) {
            set.add(str);
        }
        
//         // 탐색 (1) ➡️ 시간초과
//         for (int i=0; i<phone_book.length; i++) {
//             String prefix = phone_book[i];
            
//             for (String str : set) {
//                 if (str.equals(prefix)) {
//                     continue;
//                 }
//                 if (str.startsWith(prefix)) {
//                     return false;
//                 }
//             }
//         }
        
        // 탐색 (2)
        for (String str : set) {
            for (int i=1; i<str.length(); i++) {
                if (set.contains(str.substring(0,i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
/*
방법1. 단순 전체탐색을 통한 확인
(1) Arrays.sort() 를 통해서 길이별 정렬
    가) 문자열의 길이별로 sort 하는 방법
(2) 맨 앞부터 접두어 동일 확인
    ex) 접두어 : 3자리 / 확인 번호 : 5자리
    가) 문자열로 비교 
        a) 접두어.equals(확인번호.subString(0, 접두어크기)); ➡️ return
            ➡️ 시간이 좀 걸리는 단점이 있는듯 (효율성 테스트에 문제 생김)
    나) 숫자로 비교 -> 속도측면에서 맞지 않을까..? but String 으로 들어옴
방법2. HashSet 사용
(1) 문자열 비교 방식 개션
➡️ String 내부 메서드인 startsWith(String prefix) 사용
(2) Set 사용 방식
a) 전화번호를 하나씩 HashSet 에 저장
➡️ 길이에 상관없이 HashCode 값으로 변환 후 인덱스화 되어 저장되므로 효율적
(3) 탐색방식
*/