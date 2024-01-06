import java.util.*;

class Solution {
    static int attSize; // 속성 개수
    static int rowSize; // row 개수
    static String[][] relCopy;
    static List<HashSet<Integer>> candList = new ArrayList<>();
    
    public int solution(String[][] relation) {
        
        attSize = relation[0].length;
        rowSize = relation.length;
        relCopy = relation;
        
        for (int i=0; i<attSize; i++) {
            HashSet<Integer> set = new HashSet<>();
            comb(0, i+1, 0, set);
        }
        
        // // 후보키 확인
        // for (HashSet<Integer> set : candList) {
        //     for (int att : set) {
        //         System.out.printf("%d ", att);
        //     }
        //     System.out.println();
        // }
        
        return candList.size();
    }
    public static void comb (int idx, int size, int depth, HashSet<Integer> set) {
        // 조합 완료
        if (size == depth) {
            // 유일성 확인
            if (!isUnique(set)) {
                // for (int att : set) {
                //     System.out.printf("%d ", att);
                // }
                // System.out.println("유일성 탈락");
                return;
            }
            // 최소성 확인
            if (!isMinimal(set)) {
                return;
            }
            candList.add(set);
            return;
        }
        
        // 조합 진행
        for (int j=idx; j<attSize; j++) {
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.add(j);
            comb(++idx, size, depth + 1, newSet);
        }
    }
    
    public static boolean isUnique(HashSet<Integer> set) {
        List<String> strList = new ArrayList<>();
        String str= "";
        
        for (int k=0; k<rowSize; k++) {
            for (int att : set) {
                str += relCopy[k][att];
            }
            
            if (strList.contains(str)) {
                return false;
            }
            
            // // 문자열 확인
            // System.out.println(str);
            
            strList.add(str);
            str = "";
        }
        // System.out.println("유일성 테스트 종료");
        return true;
    }
    
    public static boolean isMinimal(HashSet<Integer> set) {
        for (HashSet<Integer> candSet : candList) {
            if (set.containsAll(candSet)) {
                return false;
            }
        }
        return true;
    }
}