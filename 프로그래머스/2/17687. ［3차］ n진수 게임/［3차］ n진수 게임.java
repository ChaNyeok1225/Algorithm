import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        String str = "0";
        int value = 1;
        int idx = 0;
        int seq = 0;
        p--;
        
        
        while(true) {
            if(sb.length() == t) 
                break;
            
            if(idx == str.length()) {
                str = Integer.toString(value++, n);
                idx = 0;
            }
            if(seq == p) 
                sb.append(Character.toUpperCase(str.charAt(idx)));
            idx++;
            seq = (seq+1) % m;
        }
        
        
        
        return sb.toString();
    }
}