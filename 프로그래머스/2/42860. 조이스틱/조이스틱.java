import java.util.*;

class Solution {

    static char[] c;
    static boolean [] vis;
    static int len, answer;
    
    public int solution(String name) {
        answer = Integer.MAX_VALUE;
        
        c = name.toCharArray();
        len = c.length;
        vis = new boolean[len];
        
        for(int i = 0; i < len; i++)
            if(c[i] == 'A') vis[i] = true;
        
        dfs(0,0);
        
        return answer;
    }
    
    static void dfs(int idx, int mv) {
        int change = c[idx] - 'A' < 'Z' - c[idx] + 1 ?  c[idx] - 'A' : 'Z' - c[idx] + 1;
        vis[idx] = true;
        
        for(int i = 0; i < len; i++) {
            if(!vis[i]) break;
            if(i == len-1) {
                answer = answer < mv+change ? answer : mv+change;
                vis[idx] = false;
                return;
            }
        }
        
        int lmv = 0;
        int rmv = 0;
        for(int i = 0; i < len; i++) {
            if(!vis[(idx + i) % len]) break;
            rmv++;
        }
         for(int i = 0; i < len; i++) {
            if(!vis[(len + idx - i) % len]) break;
            lmv++;
        }
        
        dfs((idx + rmv) % len, mv+ change+rmv);
        dfs((len + idx - lmv) % len, mv+change+lmv);
        
        vis[idx] = false;
        
    }
}