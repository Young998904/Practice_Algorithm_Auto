import static java.lang.Math.*;

class Solution {
    public long solution(long n) {
        int a = (int) floor(sqrt(n));
        int b = (int) ceil(sqrt(n));
        
        return a == b ? (long) pow(a+1, 2) : -1;
    }
}