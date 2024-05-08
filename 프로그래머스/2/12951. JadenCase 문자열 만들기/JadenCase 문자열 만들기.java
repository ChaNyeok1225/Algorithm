import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char[] sen = s.toCharArray();
        boolean flag = true;
        for(int i = 0; i < sen.length; i++) {
            if(flag)
                sb.append(Character.toUpperCase(sen[i]));
            else 
                sb.append(Character.toLowerCase(sen[i]));
            
           if(sen[i] == ' ')
                flag = true;
            else
                flag = false;
        }
        
        return sb.toString();
    }
}