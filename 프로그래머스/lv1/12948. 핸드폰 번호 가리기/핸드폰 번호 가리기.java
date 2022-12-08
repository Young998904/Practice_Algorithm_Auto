class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String star ="";
        
        for (int i=0; i<len-4; i++) {
            star += "*";
        }
        
        String real = phone_number.substring(len-4);
        
        return star + real;
    }
}

/*
특정 인덱스의 시작과 끝을 정해서 특정 문자열로 바꾸는 String 내부함수는 없음.
-> 뒷 4자리를 따로 문자열로 저장 & 앞부분들에 해당하는 자릿수만큼 * 추가한 문자열 생성
두 문자열을 더해서 answe 만듦
*/