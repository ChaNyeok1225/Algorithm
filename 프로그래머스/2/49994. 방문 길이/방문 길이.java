import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[][] map = new int[11][11];
        int r = 5, c = 5;
        
        int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
        int dir, nr, nc;
        
        for(char ch : dirs.toCharArray()) {
            dir = convert(ch);
            
            nr = r + dr[dir];
            nc = c + dc[dir];
            
            if(nr < 0 || nr > 10 || nc < 0 || nc > 10)
                continue;

            if((map[r][c] & (1 << dir)) == 0)
                answer++;
            
            map[r][c] |= (1 << dir);
            map[nr][nc] |= (1 << (dir ^ 2));  
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
    
    int convert(char ch) {
        
        switch(ch) {
            case 'U':
                return 0;
                
            case 'R':
                return 1;
                
            case 'D':
                return 2;
                
            case 'L' :
                return 3;
        }
        return 0;
    }
    
}