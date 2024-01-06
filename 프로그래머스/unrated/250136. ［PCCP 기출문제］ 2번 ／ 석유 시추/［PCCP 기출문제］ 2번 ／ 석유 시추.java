import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        boolean[] area = new boolean[m];
        int[] total = new int[m];
        
        boolean[][] vis = new boolean[n][m];
        
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = { 1,0,-1,0}, dy ={0,1,0,-1};
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] || land[i][j] == 0) continue;
                vis[i][j] = true;
                q.offer(new int[] {i,j});
                area[j] = true;
                cnt = 1;
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = cur[0]+ dx[dir];
                        int ny = cur[1] + dy[dir];
                        
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                            continue;
                        if(land[nx][ny] == 0 || vis[nx][ny])
                            continue;
                        
                        cnt++;
                        area[ny] = true;
                        vis[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
                
                for(int k = 0; k < m; k++)
                    if(area[k]) {
                        area[k] = false;
                        total[k]+= cnt;
                        answer = answer > total[k] ? answer : total[k];
                    }
                
            }
        }
        
        return answer;
    }
}