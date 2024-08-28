import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        int size, idx, dup;
        String str;
        ArrayDeque<String> stack = new ArrayDeque<>();
        
        for(int k = 1; k <= len / 2; k++) {
            size = idx = dup = 0;
            while(idx < len) {
                str = s.substring(idx, (idx + k) < len ? idx + k : len);
                idx += k;
                
                if( str.equals(stack.peekLast()) ) {
                   dup++; 
                } else {
                    if(dup != 0) 
                        size += String.valueOf(dup + 1).length();
                    stack.offer(str);
                    dup = 0;
                }
            }
            if(dup != 0) 
                size += String.valueOf(dup + 1).length();
            size += stack.pollLast().length() + stack.size() * k;
            answer = answer < size ? answer : size;
            stack.clear();
        }
        
        return answer;
    }
}