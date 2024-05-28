import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        int[][] his = new int[n+1][m+1];
        
        
        int len = skill.length;
        
        int[] sk;
        int type, r1, c1, r2, c2, deg;
        for(int i = 0; i < len; i++) {
            sk = skill[i];
            
            type = sk[0];
            r1 = sk[1];
            c1 = sk[2];
            r2 = sk[3];
            c2 = sk[4];
            deg = sk[5];
            
            if(type == 1) {
                his[r1][c1] -= deg;
                his[r1][c2 + 1] += deg;
                his[r2+1][c1] += deg;
                his[r2 + 1][c2 + 1] -= deg;
            } else {
                his[r1][c1] += deg;
                his[r1][c2 + 1] -= deg;
                his[r2+1][c1] -= deg;
                his[r2 + 1][c2 + 1] += deg;
            }
        }

        int[][] sum = new int[n+1][m+1];
        
        int acc = 0;
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m + 1; j++) {
                acc += his[i][j];
                if(i != 0) {
                    acc += his[i-1][j];
                    his[i][j] += his[i-1][j];
                }
                sum[i][j] = acc;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                if(board[i][j] + sum[i][j] > 0)
                    answer++;
            }
        }
        
        return answer;
    }
}