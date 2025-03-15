import java.util.*;

class Solution {
    
    int n;
    int m;
    int dr[] = {1,0,-1,0}, dc[] = {0,1,0,-1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        n = storage.length + 2;
        m = storage[0].length() + 2;
        
        char[][] map = new char[n][m];
        for(int i = 1; i < n - 1; i++) {   
            for(int j  = 1; j < m - 1; j++) {
                map[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        int len = requests.length;
        for(int t = 0; t < len; t++) {
            String req = requests[t];
            
            switch(req.length()) {
                case 1:
                    bfs(map, req.charAt(0));
                    break;
                case 2:
                    useCrain(map, req.charAt(0));
                    break;
            }
            
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0)
                    answer++;
            }
        }
        
        return answer;
    }
    
    void bfs(char[][] map, char target) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean [][] vis = new boolean[n][m];
        
        q.offer(new int[] {0, 0});
        vis[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || vis[nr][nc])
                    continue;
                
                vis[nr][nc] = true;
                
                
                if(map[nr][nc] == 0) {
                    q.offer(new int[] {nr, nc});
                }
                if(map[nr][nc] == target)
                    map[nr][nc] = 0;
            }
            
        }
        
        
    }
    
    void useCrain(char[][] map, char target) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == target)
                    map[i][j] = 0;
            }
        }
    }
    
}