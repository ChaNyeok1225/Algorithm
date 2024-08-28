import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && prices[stack.peekLast()] > prices[i]) {
                answer[stack.peekLast()] = i - stack.pollLast();
            }
            stack.offer(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.peekLast()] = n - stack.pollLast() - 1;
        }
        
        return answer;
    }
}