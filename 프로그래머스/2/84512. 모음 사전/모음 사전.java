import java.util.*;

class Solution {
    
    static char[] c = {'A', 'E', 'I', 'O', 'U'};
    static int index, answer;
    static StringBuilder sb = new StringBuilder();

    public int solution(String word) {
        dfs(word);
        return answer;
    }
    
    static void dfs(String word) {
        if(answer != 0)
            return;
        
        if(word.equals(sb.toString())) {
            answer = index;
            return;
        }
        index++;
        
        if(sb.length() == 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            sb.append(c[i]);
            dfs(word);
            sb.setLength(sb.length()-1);
        }

    }
}