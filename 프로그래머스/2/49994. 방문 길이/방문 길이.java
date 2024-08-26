import java.util.*;

class Solution {
    
    
    
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dr = {-1,1,0,0}, dc = {0,0,1,-1};
        
        int[][] map = new int[11][11];
        int r = 5, c = 5, nr, nc;
        
        for(int i = 0; i < dirs.length(); i++) {
            int d = convert(dirs.charAt(i));
            
            nr = r + dr[d];
            nc = c + dc[d];
            if(nr < 0 || nr > 10 || nc < 0 || nc > 10)
                continue;
            
            if((map[r][c] & (1 << d)) == 0) {
                answer++;
            }
            
            map[r][c] |= (1 << d);
            map[nr][nc] |= (1 << (d ^ 1));
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
    
    static int convert(char c) {
        if(c == 'U')
            return 0;
        else if(c == 'D')
            return 1;
        else if(c == 'R')
            return 2;
        else
            return 3;
    }
}