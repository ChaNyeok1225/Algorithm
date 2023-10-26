import java.util.*;

class Solution {
    
    static HashMap<String,Integer> map = new HashMap<>();
    static char[] c = {'A', 'E', 'I', 'O', 'U'};
    static char[] str = new char[5];
    static int index = 0;
    
    public int solution(String word) {
        dfs(0);
        return map.get(word);
    }
    
    static void dfs(int cnt) {
       map.put(String.copyValueOf(str, 0, cnt), index++);
        
        if(cnt == 5)
            return;
        
        for(int i = 0; i < 5; i++) {
            str[cnt] = c[i];
            dfs(cnt+1);
        }
        
    }
}