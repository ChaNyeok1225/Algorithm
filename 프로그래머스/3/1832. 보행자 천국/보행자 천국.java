// 키워드

// -   경로의 전체 개수
// -   도로의 종류 0, 1, 2
// -   m, n 은 500 이하

// 접근법
// -   경로의 전체 개수 탐색 문제, DFS 또는 DP
// -   맵 크기로 인해 DFS는 불안함, DP로 판단
// -   오른쪽 또는 아래로만 갈 수 있기 때문에 [n][m][2]의 DP

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][][] dp = new int[2][m+1][n+1];
        dp[0][0][0] = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[0][i][j] %= MOD;
                dp[1][i][j] %= MOD;
                
                if(cityMap[i][j] == 0) {
                    dp[1][i+1][j] += dp[0][i][j] + dp[1][i][j];
                    dp[0][i][j+1] += dp[0][i][j] + dp[1][i][j];
                } else if(cityMap[i][j] == 2) {
                    dp[1][i+1][j] += dp[1][i][j];
                    dp[0][i][j+1] += dp[0][i][j];
                }
                
            }
        }
        
        answer = (dp[0][m-1][n-1] + dp[1][m-1][n-1]) % MOD;
        return answer;
    }
}