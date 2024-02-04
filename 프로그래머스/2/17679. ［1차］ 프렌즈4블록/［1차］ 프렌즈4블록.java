import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        int[] dx = {0, 0, 1, 1}, dy = {0, 1, 0, 1};
            
        boolean[][] vis = new boolean[m][n];
        char[][] map = new char[m][n];
        for(int i = 0; i < m; i++)
            map[i] = board[i].toCharArray();
        
        while(true) {
            int chk = 0;
            
            for(int i = 0; i < m - 1; i++) {
                l : for(int j = 0; j < n - 1; j++) {
                    if(map[i][j] == '0')continue;
                    
                    
                    char pivot = map[i][j];
                    
                    for(int k = 0; k < 4; k++) {
                        if(pivot != map[i+dx[k]][j+dy[k]])
                            continue l;
                    }

                    for(int k = 0; k < 4; k++) {
                        if(!vis[i+dx[k]][j+dy[k]]) {
                            vis[i+dx[k]][j+dy[k]] = true;
                            chk++;
                        }
                    }

                }
            }
            
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(vis[i][j]) {
                        vis[i][j] = false;
                        map[i][j] = '0';
                    }
                }
            }
            
            Queue<Character> q = new ArrayDeque<>();
            
            for(int i = 0; i < n; i++) {
                for(int j = m-1; j >= 0; j--) {
                    if(map[j][i] != '0') {
                        q.offer(map[j][i]);
                        map[j][i] = '0';
                    }
                }
                 for(int j = m-1; j >= 0; j--) {
                    if(!q.isEmpty()) {
                        map[j][i] = q.poll();
                    }
                }
            }
            
            if(chk == 0)
                break;
            
            answer += chk;
        }
        
        return answer;
    }
}