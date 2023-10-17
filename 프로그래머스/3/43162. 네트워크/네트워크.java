import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] vis = new boolean[n];
        
        Queue<Integer> q = new ArrayDeque<>();
        
        int answer = 0;
        for(int i = 0; i  < n; i++) {
            if(vis[i]) continue;
            
            vis[i] = true;
            q.offer(i);
            answer++;
            
            while(!q.isEmpty()) {
                int cur = q.poll();
                
                for(int j = 0;  j < n; j++) {
                    if(vis[j] || computers[cur][j] == 0)   continue;

                    vis[j] =true;
                    q.offer(j);

                }
            }
        }
        return answer;
        
    }
}