import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        boolean[] peek = new boolean[n+1];
        boolean[] start = new boolean[n+1];
        for(int i = 0;i < summits.length; i++) 
            peek[summits[i]] = true;
        
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        
        for(int i = 0; i < paths.length; i++) {
            graph[paths[i][0]].add(new int[] {paths[i][1], paths[i][2]});
            graph[paths[i][1]].add(new int[] {paths[i][0], paths[i][2]});
        }
        
        PriorityQueue<Data> q = new PriorityQueue<>( (a,b) -> a.max - b.max);
        
        int[] minEdge = new int[n+1];
        Arrays.fill(minEdge , Integer.MAX_VALUE);
        
        boolean[] vis = new boolean[n+1];
        for(int i = 0; i < gates.length; i++) {
            start[gates[i]] = true;
            minEdge[gates[i]] = 0;
            q.offer(new Data(gates[i], 0));
        }   
        
        while(!q.isEmpty()) {
            Data cur = q.poll();
            
            if(vis[cur.idx]) continue;
            vis[cur.idx]  = true;
            
            minEdge[cur.idx] = minEdge[cur.idx] < cur.max ? minEdge[cur.idx] : cur.max;
            if(peek[cur.idx]) continue;
            
            for(int[] nxt : graph[cur.idx]) {
                if(vis[nxt[0]] || start[nxt[0]]) continue;
                q.offer(new Data(nxt[0],Math.max(cur.max, nxt[1])));
            }
        }
        
        int sel = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n+1; i++) {
            if(peek[i]) {
                if(min > minEdge[i]) {
                    min = minEdge[i];
                    sel = i;
                }
            }
        }
        
        return new int[] {sel, min};
    }
    
    static class Data {
        int idx;
        int max;
        
        Data(int i, int j) {
            idx = i;
            max = j;
        }
    }
}