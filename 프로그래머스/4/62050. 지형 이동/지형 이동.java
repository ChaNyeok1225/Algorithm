import java.util.*;

class Solution {
    
    static int[] p, dr = {1,0}, dc = {0,1};
    static int n;
    
    public int solution(int[][] land, int height) {
        
        n = land.length; 
        ArrayList<int[]>[] edge = new ArrayList[n*n];
        
        
        p = new int[n*n];
        for(int i = 0; i < n * n; i++) {
            p[i] = i;
            edge[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int h = land[i][j];
                
                for(int d = 0; d < 2; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    
                    if(nr >= n || nc >= n)
                        continue;
                    
                    int nh = land[nr][nc];
                    
                    if(Math.abs(h - nh) <= height) {
                        union(i*n + j, nr * n + nc);
                    }
                }
            }
        }
        
       
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int g = find(i * n + j);
                int h = land[i][j];
                
                for(int d = 0; d < 2; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    
                    if(nr >= n || nc >= n)
                        continue;
                    
                    int ng = find(nr * n + nc);
                    int nh = land[nr][nc];
                    
                    if(g == ng) continue; 
                    
                    edge[g].add(new int[]{ng, Math.abs(h - nh)});
                    edge[ng].add(new int[]{g, Math.abs(h - nh)});
                }
            }
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] cost = new int[n*n];
        boolean[] vis = new boolean[n*n];
        Arrays.fill(cost, 1_000_000_000);
        q.offer(new int[] {find(0), 0});
        cost[find(0)] = 0;
        
        int answer = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(vis[cur[0]]) continue;
            vis[cur[0]] = true;
            answer += cur[1];
            
            for(int[] nxt : edge[cur[0]]) {
                if(cost[nxt[0]] <= nxt[1]) continue;
                q.offer(new int[] {nxt[0], nxt[1]});
            }
        }
        
        return answer;
    }
    
    int find(int a) {
        if(a == p[a]) return a;
        return p[a] = find(p[a]);
    }
    
    boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b)
            return false;
        
        p[b] = a;
        return true;
    }
}