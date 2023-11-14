import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            int[] cur = new int[] {prices[i], i};
            
            while(!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                int[] pop = stack.pop();
                
                answer[pop[1]] = i - pop[1];
            }
            stack.push(cur);
        }
        
        for(int i = 0; i < len; i++) {
            if(answer[i] == 0) {
                answer[i] = len-1 - i;
            }
        }
        
        return answer;
    }
}