import static java.lang.Math.*;

class Solution {
    public long solution(long n) {
//         double a = floor(sqrt(n));
//         double b = ceil(sqrt(n));
        
//         return a == b ? (long) pow(a+1, 2) : -1;
        long a = (long) sqrt(n);
        if ((long) pow(a, 2) == n) {
            return (long) pow(a+1, 2);
        }
        return -1;
    }
}