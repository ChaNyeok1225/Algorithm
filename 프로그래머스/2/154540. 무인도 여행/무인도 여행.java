import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        char[][] map = new char[n][];
        for(int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        boolean[][] vis = new boolean[n][m];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
        
        int total, cur[];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] || map[i][j] == 'X') continue;
                total = 0;
                
                vis[i][j] = true;
                q.offer(new int[]{i, j});
                while(!q.isEmpty()) {
                    cur = q.poll();
                    
                    total += map[cur[0]][cur[1]] - '0';
                    
                    for(int dir = 0; dir < 4; dir++) {
                        int nr = cur[0] + dr[dir];
                        int nc = cur[1] + dc[dir];
                        
                        if(nr < 0 || nr >= n || nc < 0 || nc >= m)
                            continue;
                        if(map[nr][nc] == 'X' || vis[nr][nc]) continue;
                        
                        q.offer(new int[] {nr, nc});
                        vis[nr][nc] = true;
                    }
                }
                pq.offer(total);
            }
        }
        if(pq.isEmpty())
            return new int[] {-1};
        
        int[] answer = new int[pq.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = pq.poll();
        return answer;
    }
}