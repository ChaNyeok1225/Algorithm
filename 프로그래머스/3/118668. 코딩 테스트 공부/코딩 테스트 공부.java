import java.util.*;

class Solution {
    
    public int solution(int alp, int cop, int[][] problems) {
        
        int targetAlp = alp;
        int targetCop = cop;
        for(int i = 0; i < problems.length; i++) {
            targetAlp = targetAlp > problems[i][0] ? targetAlp : problems[i][0];
            targetCop = targetCop > problems[i][1] ? targetCop : problems[i][1];
        }
        
        int[][] dp = new int[targetAlp + 1][targetCop + 1];
        for(int i = alp; i < targetAlp + 1; i++) {
            for(int j = cop; j < targetCop + 1; j++) {
                dp[i][j] = i-alp + j - cop;
            }
        }
        
        for(int i = alp; i < targetAlp + 1; i++) {
            for(int j = cop; j < targetCop + 1; j++) {
               
                
                for(int k = 0; k < problems.length; k++) {
                    int ti = targetAlp < i + problems[k][2] ? targetAlp : i + problems[k][2];
                    int tj = targetCop < j + problems[k][3] ? targetCop : j + problems[k][3];
                    
                    if(i >= problems[k][0] && j >= problems[k][1]) {
                        dp[ti][tj] = dp[ti][tj] < dp[i][j] + problems[k][4] ?
                                       dp[ti][tj] : dp[i][j] + problems[k][4]; 
                    }
                }
            }
        }
        
        return dp[targetAlp][targetCop];
    }
    
}