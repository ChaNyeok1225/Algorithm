import java.util.*;

class Solution {
    public long solution(long n) {
        char[] c = String.valueOf(n).toCharArray();
        
        Arrays.sort(c);
        
        long answer = 0;
        for(int i = c.length - 1; i >= 0; i--) {
            answer *= 10;
            answer += (int)(c[i] - '0');
        }
        
        return answer;
    }
}