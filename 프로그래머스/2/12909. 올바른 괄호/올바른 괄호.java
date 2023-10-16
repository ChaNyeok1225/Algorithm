import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
    
        char[] cha = s.toCharArray();
            
        Stack<Character> stack = new Stack<>();
        
        for(int i =0 ; i < cha.length; i++) {
            
            if(cha[i] == '(')
                stack.add(cha[i]);
            else {
                if(stack.isEmpty() || stack.peek() != '(') {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty())
            answer = false;
        
        return answer;
    }
}