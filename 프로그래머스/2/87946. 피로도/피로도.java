class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(0, k, dungeons, new boolean[dungeons.length]);
        return answer;
    }
    
    static void dfs(int cnt, int cur, int[][] dungeons, boolean[] vis) {
        if(cnt > answer)
            answer = cnt;
        for(int i = 0; i < dungeons.length; i++) {
            if(vis[i]) continue;
            
            if(cur >= dungeons[i][0]) {
                vis[i] = true;
                dfs(cnt + 1, cur - dungeons[i][1], dungeons, vis);
                vis[i] = false;
            }
        }
    }
}