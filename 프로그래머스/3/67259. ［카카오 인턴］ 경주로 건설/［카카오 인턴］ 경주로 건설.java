import java.util.*;

class Solution {
    
    static class Data {
        int x;
        int y;
        int cost;
        int dir;
        
        Data(int a, int b, int c, int d) {
            x = a;
            y= b;
            cost = c;
            dir = d;
        }
        
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
        int[][][] dist = new int[n][n][4];
        
        
        PriorityQueue<Data> q = new PriorityQueue<>( (a,b) -> a.cost - b.cost );
        
        for(int dir = 0; dir < 4; dir++)
            q.offer(new Data(0,0,0,dir));
        
        while(!q.isEmpty()) {
            Data cur = q.poll();
            
            if(dist[cur.x][cur.y][cur.dir] != 0)
                continue;
            dist[cur.x][cur.y][cur.dir] = cur.cost;
            
            if(cur.x == n - 1 && cur.y == n - 1) {
                answer = cur.cost;
                break;
            }
            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                
                if(valid(nx,ny,n) || board[nx][ny] == 1)
                    continue;
                    
                int plus = 600;
                if(dir == cur.dir)
                    plus = 100;
                
                q.offer(new Data(nx,ny,cur.cost+plus, dir));
            }
            
        }
        
        return answer;
    }
    
    static boolean valid(int x, int y, int n){
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}