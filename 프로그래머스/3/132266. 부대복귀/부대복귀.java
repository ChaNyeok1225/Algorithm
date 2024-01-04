import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, 150000);
        dist[destination] = 0;
        boolean[] vis = new boolean[n+1];
        
        q.offer(new int[] {destination, dist[destination]});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(vis[cur[0]]) continue;
            vis[cur[0]] = true;
            
            for(int nxt : graph[cur[0]]) {
                if(dist[nxt] <= cur[1] + 1) continue;
                dist[nxt] = cur[1] + 1;
                q.offer(new int[] {nxt, dist[nxt]});
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i =0 ; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
            if(answer[i] == 150000)
                answer[i] = -1;
        }
        
        return answer;
    }
}