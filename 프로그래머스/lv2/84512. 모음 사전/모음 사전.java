import java.util.Arrays;

class Solution {
    public static String[] alphabet = {"A", "E", "I", "O", "U"};
    public static int answer = 0;
    public static boolean go = true;
    
    public int solution(String word) {
        String[] words = word.split("");
        
        dfs (words, 0, new String[words.length]);
       
        return answer;
    }
    public static void dfs (String[] words, int depth, String[] output) {
        if (depth == 5) {
            return;
        }
        for (int i=0; i<5; i++) {
            if (depth < words.length) {
                output[depth] = alphabet[i];
            }
            answer++;
            if (depth == words.length-1 && Arrays.equals(words, output)) {
                go = false;
                break;
            }
            dfs(words, depth+1, output);
            if (!go) {
                return;
            }
        }

    }
}
/*
중복순열
[A, B, C]
[A]
[A, A]
[A, A, A]
[A, A, B]
[A, A, C]
[A, B]
[A, B, A]
[A, B, B]
[A, B, C]
...
비교방식
*/