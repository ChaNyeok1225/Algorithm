import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
       
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.offer(new int[] {storey, 0});
        
        int[] cur;
        int x, nxt, ex;
        while(!q.isEmpty()) {
            cur = q.poll();
            
            if(cur[0] == 0) {
                answer = cur[1];
                break;
            }
            
            nxt = cur[0] / 10;
            ex = cur[0] % 10;
            
            q.offer(new int[] {nxt, cur[1] + ex});
            q.offer(new int[] {nxt + 1, cur[1] + 10 - ex});
        }
        
        return answer;
    }
}