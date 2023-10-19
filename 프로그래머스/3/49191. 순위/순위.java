import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] graph = new int[n+1][n+1];
        int INF = 100000;
        
        for(int i = 1; i < n+1; i++)
            Arrays.fill(graph[i], INF);
        
        for(int i = 0; i < results.length; i++) 
            graph[results[i][0]][results[i][1]] = 1;   
        
        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                if(i==k) continue;
                for(int j = 1; j < n + 1; j++) {
                    if(j == k || j == i) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for(int j = 1; j < n + 1; j++) {
                if(graph[i][j] < INF || graph[j][i] < INF)
                    cnt++;
            }
            if(cnt == n-1)
                answer++;
        }
        
        return answer;
    }
}