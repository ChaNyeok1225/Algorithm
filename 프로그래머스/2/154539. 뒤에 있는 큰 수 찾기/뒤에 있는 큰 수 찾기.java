import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < numbers.length; i++) {
            
            while(!stack.isEmpty() && numbers[stack.peekLast()] < numbers[i]) {
                answer[stack.pollLast()] = numbers[i];
            }
            
            stack.offer(i);
        }
        
        while(!stack.isEmpty())
            answer[stack.pollLast()] = -1;
        
        return answer;
    }
}