import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int n = lock.length;
        int m = key.length;
        int ex = m + 2 * n - 2;
        
        
        int[][][] keys = new int[4][ex][ex];
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < m; j++)
                keys[0][n + i - 1][n + j - 1] = key[i][j];
        
        for(int d = 1; d < 4; d++) {
            keys[d] = rotCW(keys[d-1], keys[0].length, keys[0].length);      
        }
        
        int blankCount = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                blankCount += lock[i][j] == 0 ? 1 : 0;
        
        int tmpCount, value;
        
        for(int d = 0; d < 4; d++) {
            key = keys[d];
            
            for(int i = 0; i < ex - n + 1; i++) {
                next : for(int j = 0; j < ex - n + 1; j++) {
                    
                    tmpCount = 0;
                    
                    for(int r = 0; r < n; r++) {
                        for(int c = 0; c < n; c++) {
                            value = lock[r][c] + key[i + r][j + c];
                            if(value != 1)
                                continue next;
                            if(lock[r][c] == 0 && key[i+r][j+c] == 1)
                                tmpCount++;
                        }
                    }
                    
                    if(tmpCount == blankCount)
                        return true;
                }
            }
            
        }
        
        
        return false;
        
    }
    
    int[][] rotCW(int[][] arr, int r, int c) {
        int[][] tmp = new int[c][r];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                tmp[i][j] = arr[r-j-1][i];
            }
        }   
        return tmp;
    }
}