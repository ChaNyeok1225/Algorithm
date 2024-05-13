import java.util.*;

class Solution {

    
    public int solution(String s) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            
            if(!q.isEmpty() && q.peekLast() == c[i]) {
                q.pollLast();
            }else {
                q.offer(c[i]);
            }
        }
        

        return q.isEmpty() ? 1 : 0;
    }
}