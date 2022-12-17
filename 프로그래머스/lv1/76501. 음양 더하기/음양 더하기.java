class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i=0; i<signs.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
                continue;
            } 
            answer -= absolutes[i];
        }
        
        return answer;
    }
}

/*
반복문을 돌면서 합을 구하면 OK
합이므로 정수형의 범위를 넘지 않는지 확인할 필요가있음
*/