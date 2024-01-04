import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        long answer = -100000;
        
        long sum1 = 0;
        long sum2 = 0;
        
        int val = 1;
        for(int i = 0; i < n; i++) {
            if(sum1 < 0)
                sum1 = 0;
            if(sum2 < 0)
                sum2 = 0;
            
            sum1 += val * sequence[i];
            sum2 += -val * sequence[i];
            
            answer = answer > sum1 ? answer : sum1;
            answer = answer > sum2 ? answer : sum2;
            
            val = -val;
        }
        
        return answer;
    }
}