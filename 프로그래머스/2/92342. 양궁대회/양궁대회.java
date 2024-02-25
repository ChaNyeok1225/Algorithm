import java.util.*;

class Solution {
    
    static int maxDiff = 0;
    static int[] answer = new int[11];
    static int[] sel = new int[11];
    
    public int[] solution(int n, int[] info) {
        
        int aScore = 0;
        for(int i = 0; i < 11; i++) {
            if(info[i] > 0)
                aScore += 10 - i;
        }
        
        dfs(0, 0, 0, aScore, n, info);
        
        
        if(maxDiff == 0)
            return new int[] {-1};
        return answer;
    }
    
    static void dfs(int idx, int cnt, int score, int aScore, int n, int[] info) {
        if(idx == 10 || cnt > n) {
            return;
        }
        
        int diff = score - aScore;
        if(maxDiff == diff) {
            for(int i = 10; i >= 0; i--) {
                if(answer[i] > sel[i])
                    break;
                if(answer[i] < sel[i]) {
                    for(int j = 0; j < 11; j++)
                        answer[j] = sel[j];
                    
                    break;
                }
            }
        }
        else if(maxDiff < diff) {
            maxDiff = diff;
            for(int i = 0; i < 11; i++)
                answer[i] = sel[i];
            if(cnt < n)
                answer[10] += n - cnt;
        }
        maxDiff = maxDiff > diff ? maxDiff : diff;
        
        dfs(idx + 1, cnt, score, aScore, n, info);
        sel[idx] = info[idx]+1;
        if(info[idx] > 0)
            dfs(idx + 1, cnt + info[idx] + 1, score + 10 - idx, aScore - 10 + idx, n, info);
        else
            dfs(idx + 1, cnt + info[idx] + 1, score + 10 - idx, aScore, n, info);
        
        sel[idx] = 0;
    }
    
}