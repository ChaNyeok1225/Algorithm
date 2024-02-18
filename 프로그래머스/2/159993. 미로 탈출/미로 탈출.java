import java.util.*;

class Solution {
    
    static int n,m;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int[] sp = new int[2];
        int[] lp = new int[2];
        int[] ep = new int[2];
        
        n = maps.length;
        m = maps[0].length();
        
        for(int i = 0; i < n; i++) {
            char[] map = maps[i].toCharArray();
            for(int j = 0; j < m; j++) {
                if(map[j] == 'S') {
                    sp[0]=i;sp[1]=j;
                }else if(map[j] == 'L'){
                    lp[0]=i;lp[1]=j;
                }else if(map[j]=='E') {
                    ep[0]=i;ep[1]=j;
                }
            }
        }
        
        int[][] dist = new int[n][m];
        
        bfs(dist, sp, lp, maps);
        if(dist[lp[0]][lp[1]] == 0)
            return -1;
        answer += dist[lp[0]][lp[1]];
        
        dist = new int[n][m];
        bfs(dist, lp, ep, maps);
        if(dist[ep[0]][ep[1]] == 0)
            return -1;
        answer += dist[ep[0]][ep[1]];
        
        
        
        return answer;
    }
    
    static void bfs(int[][] dist, int[] start, int[] end, String[] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        
        int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == end[0] && cur[1] == end[1])
                break;
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(maps[nx].charAt(ny) == 'X' || dist[nx][ny] > 0)
                    continue;
                                
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int [] {nx, ny});
            }
        }
    }
}