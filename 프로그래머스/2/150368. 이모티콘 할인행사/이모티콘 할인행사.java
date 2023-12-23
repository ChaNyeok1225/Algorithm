import java.util.*;

class Solution {
    
    static int n, m, answer[], sel[];
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        n = users.length;
        m = emoticons.length;
        
        sel = new int[m];
        
        dfs(0, users, emoticons);
        
        return answer;
    }
    
    static void dfs(int idx,int[][] users, int[] emoticons) {
        if(idx == m) {
            int total = 0;
            int plus = 0;
            
            for(int i = 0; i < n; i++) {
                int sum = 0;
                
                for(int j = 0; j < m; j++) {
                    if(sel[j] < users[i][0]) continue;
                    sum += emoticons[j] * (100 - sel[j]) / 100;
                }
                
                if(sum >= users[i][1])
                    plus++;
                else
                    total+=sum;
            }
            
            if(plus > answer[0]) {
                answer[0] = plus;
                answer[1] = total;
            } else if (plus == answer[0] && total > answer[1]) {
                answer[1] = total;
            }
            
            return;
        }
        
        for(int i = 10; i <= 40; i += 10) {
            sel[idx] = i;
            dfs(idx+1, users, emoticons);
        }
        
    }
}