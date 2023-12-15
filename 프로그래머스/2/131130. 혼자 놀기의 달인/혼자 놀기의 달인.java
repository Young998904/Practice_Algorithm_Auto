import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] cards) {
        
        // 초기화
        boolean[] opened = new boolean[cards.length]; // opened 배열  
        ArrayList<Integer> boxCntList = new ArrayList<>(); // 그룹별 box 개수를 담는 리스트
        
        // 그룹화 과정
        int boxCnt = 0;
        int next = 0;
        for (int i=0; i<cards.length; i++) {
            if (opened[i]) continue;
            opened[i] = true;
            boxCnt++;
            next = cards[i];
            
            while (!opened[next-1]) {
                opened[next-1] = true;
                boxCnt++;
                next = cards[next-1];
            }
            
            boxCntList.add(boxCnt);
            boxCnt = 0;
        }
    
        Collections.sort(boxCntList); // 오름차순 정렬
        
        int size = boxCntList.size();
        
        if (size == 1) return 0; // 그룹이 1개인 경우 0점
        
        // 끝에서 두개 출력
        return (boxCntList.get(size-1)*boxCntList.get(size-2));
    }
}