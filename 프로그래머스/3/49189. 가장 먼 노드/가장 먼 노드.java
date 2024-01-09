import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        
        int max = 0, cnt = 0;
        boolean[] vis = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, dist[1]});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(vis[cur[0]]) continue;
            max = max > cur[1] ? max : cur[1];
            vis[cur[0]] = true;
            if(++cnt == n)
                break;
            
            
            for(int nxt : graph[cur[0]]) {
                if(dist[nxt] <= cur[1] + 1) continue;
                dist[nxt] = cur[1] + 1;
                q.offer(new int[] {nxt, dist[nxt]});
            }
        }
        
        int answer = 0;
        
        for(int i = 2; i < n + 1; i++) {
            if(max == dist[i])
                answer++;
        }
        
        return answer;
    }
}