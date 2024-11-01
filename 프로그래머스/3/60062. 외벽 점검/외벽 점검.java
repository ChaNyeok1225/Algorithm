import java.util.*;

class Solution {
    
    static int wlen, dlen, answer, chk;
    static int[] eweak, edist;
    static boolean[] vis;
    
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        wlen = weak.length;
        dlen = dist.length;
        
        eweak = new int[wlen * 2];
        vis = new boolean[dlen];
        edist = dist;
        chk = (1 << wlen) - 1;
        
        for(int i = 0; i < wlen; i++) {
            eweak[i] = weak[i];
            eweak[i + wlen] = weak[i] + n;
        }
        
        dfs(0, 0, 0);
        
        // 불가능하면 -1로 만드는거 놓침
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    
    void dfs(int widx, int cnt, int inspect) {
        if(answer <= cnt)
            return;
        
        if(widx >= wlen) {
            if(inspect == chk)
                answer = answer < cnt ? answer : cnt;
            return;
        }
        
        for(int i = 0; i < dlen; i++) {
            if(vis[i]) continue;
            vis[i] = true;
            
            int inspectCnt = inspect;
            int wCnt = 0;
            for(int j = widx; j < widx + wlen; j++) {
                if( eweak[widx] + edist[i] < eweak[j])
                    break;
                inspectCnt |= 1 << (j % wlen);
                wCnt++;
            }
            
            dfs(widx + wCnt, cnt + 1, inspectCnt);
            vis[i] = false;
        }
        
        dfs(widx + 1, cnt, inspect);
        
    }
}