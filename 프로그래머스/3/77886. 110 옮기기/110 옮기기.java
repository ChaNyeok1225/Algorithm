import java.util.*;

class Solution {
    
    int[] kmp;
    char[] search;
    ArrayDeque<Character> q, tmp;
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        search = new char[] {'1', '1', '0'};
        kmp = new int[] {0, 1, 0};
        
        int cnt, j, ex;
        char[] str;
        boolean flag;
        tmp = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder zzo = new StringBuilder();
        
        for(int t = 0; t < s.length; t++) {
            str = s[t].toCharArray();
            cnt = j = 0;
            q = new ArrayDeque<>();
            
            for(int i = 0; i < str.length; i++) {
                if(j > 0 && str[i] != search[j]) j = kmp[j-1];
                if(str[i] == search[j]) ++j;
                
                q.offer(str[i]);
                
                if(j == 3) {
                    j = replaceQueue();
                    cnt++;
                }
            }
            
            for(int i = 0; i < cnt; i++) {
                zzo.append("110");
            }
            
            while(!q.isEmpty())
                sb.append(q.poll());
            
            sb.insert(findMin(sb.toString()), zzo);
            
            answer[t] = sb.toString();
            sb.setLength(0);
            zzo.setLength(0);
        }
        
        return answer;
    }
    
    int findMin(String s) {
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != '1') --j;
            if(s.charAt(i) == '1') ++j;
            if(j == 3) 
                return i - 2;
        }
        return s.length() - j;
    }
    
    int replaceQueue() {
        
        for(int i = 0; i < 3; i++)
            q.pollLast();
        
        for(int i = 0; i < 2 && !q.isEmpty(); i++) 
            tmp.offer(q.pollLast());
    
        int j = 0;
        char c;
        
        while(!tmp.isEmpty()) {
            c = tmp.pollLast();
       
            while(j > 0 && c != search[j]) j = kmp[j-1];
            if(c == search[j]) ++j;
            
            q.offer(c);
        }
        
        return j;
    }
}