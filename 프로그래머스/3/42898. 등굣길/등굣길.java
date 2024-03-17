class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][]dp = new int[n+1][m+1];
        boolean[][] puddle = new boolean[n+1][m+1];
        dp[0][1] = 1;
        for(int i = 0; i < puddles.length; i++) {
            puddle[puddles[i][1]][puddles[i][0]] = true;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(puddle[i][j]) continue;
                dp[i][j] =  (dp[i-1][j] + dp[i][j-1]) % 1_000_000_007;        
            }
        }
        
        return dp[n][m];
    }
}