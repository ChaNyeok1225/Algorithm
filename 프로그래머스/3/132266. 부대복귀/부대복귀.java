import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int len = sources.length;
        int[] answer = new int[len];
        
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : roads) {
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
            
        ArrayDeque<Integer> q = new ArrayDeque<>();            
        
        int[] cost = new int[n+1];
        Arrays.fill(cost, -1);
        
        q.offer(destination);
        cost[destination] = 0;
        
        int cur, size, step = 0;
        while(!q.isEmpty()) {
            
            size = q.size();
            step++;
            for(int i = 0; i < size; i++) {
                cur = q.poll();
                for(int nxt : graph[cur]) {
                    if(cost[nxt] != -1) continue;
                    cost[nxt] = step;
                    q.offer(nxt);
                }
            }
        }        
        
        for(int i = 0; i < len; i++) {
            answer[i] = cost[sources[i]];
        }
        
        return answer;
    }
}