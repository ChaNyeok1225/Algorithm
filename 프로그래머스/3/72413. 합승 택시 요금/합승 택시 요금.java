import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] dist = new int[n+1][n+1];
        
        int INF = 1_000_000_000;
        for(int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++) {
            int[] fare = fares[i];
            dist[fare[0]][fare[1]] = fare[2];         
            dist[fare[1]][fare[0]] = fare[2];
        }
        
        for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					dist[i][j] = dist[i][j] < dist[i][k] + dist[k][j] ? dist[i][j] : dist[i][k] + dist[k][j];
				}
			}
		}
        
        // for(int i = 1; i < n + 1; i++) {
        //     System.out.print(String.format("%d : ", i));
        //     for(int j  = 1; j < n + 1; j++) {
        //         System.out.print(String.format("%10d , ", dist[i][j]));
        //     }
        //     System.out.println();
        // }
        
        int answer = Integer.MAX_VALUE;
        
        int temp;
        for(int i = 1; i < n + 1; i++) {
            temp = 0;
            if(dist[s][i] >= INF)
                continue;
            temp = temp + dist[s][i];
            
            if(dist[i][a] >= INF || dist[i][b] >= INF)
                continue;
            temp = temp + dist[i][a] + dist[i][b];
            
            answer = answer < temp ? answer : temp;
        }
        
        return answer;
    }
}