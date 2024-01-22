class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // // // 기본 아이디어
        // System.out.println(skill_trees[2].indexOf(skill.charAt(0)));
        // System.out.println(skill_trees[2].indexOf(skill.charAt(1)));
        // System.out.println(skill_trees[2].indexOf(skill.charAt(2)));
        
        int position = 0;
        int limit = -1;
        boolean isPossible = true;
        boolean isActivated = false;
        
        for (String str : skill_trees) {
            for (int i=0; i<skill.length(); i++) {
                position = str.indexOf(skill.charAt(i));
                
                if (isActivated) { // 뒤에 더 이상 스킬이 나올 수 없는 경우
                    if (position >= 0) isPossible = false;
                }
                else {
                    if (position == -1) { // 조건 (2)-1
                        isActivated = true;
                        continue;
                    }
                    
                    if (limit < position) { // 조건 (2)-2
                        limit = position;
                    }
                    else {
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if (isPossible) answer++;
            
            // 초기화
            position = 0;
            limit = -1;
            isPossible = true;
            isActivated = false;
        }
        
        return answer;
    }
}