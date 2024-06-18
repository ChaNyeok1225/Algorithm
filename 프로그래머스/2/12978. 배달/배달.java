import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        ArrayList<int[]>[] edges = new ArrayList[N+1];
        for(int i = 1; i < N + 1; i++)
            edges[i] = new ArrayList<>();
        
        for(int i = 0; i < road.length; i++) {
            edges[road[i][0]].add(new int[] {road[i][1], road[i][2]});
            edges[road[i][1]].add(new int[] {road[i][0], road[i][2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, 10_000_000);
        dist[1] = 0;
        pq.offer(new int[] {1, dist[1]});
        
        int[] cur;
        while(!pq.isEmpty()) {
            cur = pq.poll();
            
            if(cur[1] > dist[cur[0]])
                continue;
            
            for(int[] nxt : edges[cur[0]]) {
                if(dist[nxt[0]] <= cur[1] + nxt[1]) 
                    continue;
                dist[nxt[0]] = cur[1] + nxt[1];
                pq.offer(new int[] {nxt[0], dist[nxt[0]]});
            }
        }
        
        for(int d : dist) {
            if(d <= K)
                answer++;
        }
        
        return answer;
    }
}