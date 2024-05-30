import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] c = s.toCharArray();
        
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(int i = 0; i < c.length; i++) {
            q.offer(c[i]);
        }
        
        boolean isSuccessed, flag;
        for(int i = 0; i < c.length; i++) {
            isSuccessed = true;
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            for(Character ch : q) {
                
                if(ch == '(' || ch == '[' || ch == '{')
                    stack.offer(ch);
                else {
                    if(ch == ')') {
                        if(!stack.isEmpty() && stack.peekLast() == '(')
                            stack.pollLast();
                        else {
                            isSuccessed = false;
                            break;
                        }
                    }
                    else if(ch == ']') {
                        if(!stack.isEmpty() && stack.peekLast() == '[')
                            stack.pollLast();
                        else {
                            isSuccessed = false;
                            break;
                        }
                    }
                    else if(ch == '}') {
                        if(!stack.isEmpty() && stack.peekLast() == '{')
                            stack.pollLast();
                        else {
                            isSuccessed = false;
                            break;
                        }
                    }
                }
            }
            if(isSuccessed && stack.size() == 0)
                answer++;
            
            q.offer(q.poll());
        }
        
        return answer;
    }
}