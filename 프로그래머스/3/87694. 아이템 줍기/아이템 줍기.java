import java.util.*;

class Solution {
    
    static int[] dx = {1,0,-1,0, 1, 1, -1, -1}, dy = {0,1,0,-1, 1, -1, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int len = rectangle.length;
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        boolean[][] map = new boolean[110][110];
        boolean[][] vis = new boolean[110][110];
        
        
        for(int i = 0; i < len; i++) {
            int[] rect = rectangle[i];
            for(int x  = rect[0]*2; x <= rect[2]*2; x++) {
                for(int y = rect[1]*2; y <= rect[3]*2; y++) {
                    map[x][y] = true;
                }
            }
        }

        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {characterX, characterY, 0});
        vis[characterX][characterY] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == itemX && cur[1] == itemY) {
                answer = cur[2];
                break;
            }
            
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
               
                if(!map[nx][ny] || vis[nx][ny]) continue;
                
                
                if(check(nx,ny, map)) {
                    q.offer(new int[] {nx,ny, cur[2]+1});
                    vis[nx][ny] = true;
                }
                
            }
            
        }
        
        
        return answer / 2;
    }
    
    boolean check(int x, int y, boolean[][] map) {
        for(int dir = 0; dir < 8; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(!map[nx][ny])
                return true;
            
        }
        return false;
            
    }

}