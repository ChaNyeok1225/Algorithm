import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] vis;
    
    public int solution(int n, int[][] wires) {
     
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < n - 1; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
           
        vis = new boolean[n+1];
        for(int i = 0; i < n-1; i++) {
            vis[wires[i][0]] = vis[wires[i][1]] = true;
            int cnt = dfs(wires[i][1]);
            if(Math.abs(n-2*cnt) < answer)
                answer = Math.abs(n-2*cnt);
            Arrays.fill(vis, false);
        }
        
        return answer;
    }
    
    static int dfs(int idx) {
        
        int cnt = 0;
        for(int nxt : graph[idx]) {
            if(vis[nxt]) continue;
            vis[nxt] = true;
            cnt += dfs(nxt);
        }
        
        return 1 + cnt;
    }
    
}