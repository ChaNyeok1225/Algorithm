import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n+1))/ 2];
        
        int[][] snail = new int[n][n];
        
        int[] dr = {1,0,-1}, dc = {0,1,-1};
        
        int decN = n;
        int count = 0;
        int dir = 0;
        int num = 1;
        int r = 0, c = 0;
        while(decN != 0) {
            snail[r][c] = num++;
            count++;
            
            if(decN == count) {
                count = 0;
                dir = (dir + 1) % 3;
                decN--;
            }
            r += dr[dir];
            c += dc[dir];
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = snail[i][j];
            }
        }        
        
        return answer;
    }
}