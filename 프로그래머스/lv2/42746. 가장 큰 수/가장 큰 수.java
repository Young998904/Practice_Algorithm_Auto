import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] numbers) {
        String answer = IntStream.of(numbers)
            .mapToObj(n->String.valueOf(n))
            .sorted((s1,s2)->(s2+s1).compareTo(s1+s2))
            .collect(Collectors.joining());

        if (answer.startsWith("0")) answer = "0";
        
        return answer;
    }
}