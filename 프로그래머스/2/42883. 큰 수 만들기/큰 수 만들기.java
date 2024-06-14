import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] num = number.toCharArray();
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        int removeCount = 0;
        for(int i = 0; i < num.length; i++) {
            char c = num[i];
            
            while(!stack.isEmpty() && stack.peekLast() < c && removeCount < k) {
                stack.pollLast();
                removeCount++;
            }
            stack.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack) 
            sb.append(c);
        sb.setLength(sb.length() - (k - removeCount));
        return sb.toString();
        
    }
}