import java.util.*;

class Solution {
    static int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][][] dp = new int[2][m+1][n+1];
        
        dp[0][0][0] = 1;
        // 0 오른쪽, 1 아래
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[0][i][j] %= MOD;
                dp[1][i][j] %= MOD;
                if(cityMap[i][j] == 0) {
                    dp[1][i+1][j] += dp[0][i][j] + dp[1][i][j];
                    dp[0][i][j+1] += dp[0][i][j] + dp[1][i][j];
                } else if(cityMap[i][j] == 1) {
                    continue;
                } else if(cityMap[i][j] == 2) {
                    dp[1][i+1][j] += dp[1][i][j];
                    dp[0][i][j+1] += dp[0][i][j];
                }
            }
        }
        
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++)
        //         System.out.print(dp[0][i][j] + dp[1][i][j] + ", ");
        //     System.out.println();
        // }
        
        return (dp[0][m-1][n-1] + dp[1][m-1][n-1]) % MOD;
    }
}
