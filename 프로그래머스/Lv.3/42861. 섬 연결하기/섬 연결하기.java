import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < costs.length; i++) {
            graph[costs[i][0]].add(new int[] {costs[i][1], costs[i][2]});
            graph[costs[i][1]].add(new int[] {costs[i][0], costs[i][2]});
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        boolean[] vis = new boolean[n];
        int[] minEdge = new int[n];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        q.offer(new int[] {0, 0});
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(vis[cur[0]]) continue;
            vis[cur[0]] = true;
            answer += cur[1];
            if(++cnt == n)
                break;
            
            for(int[] nxt : graph[cur[0]]) {
                if(minEdge[nxt[0]] <= nxt[1])
                    continue;
                minEdge[nxt[0]] = nxt[1];
                q.offer(new int[] {nxt[0], minEdge[nxt[0]]});
            }
        
        }
        
        return answer;
    }
}