import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] count = new int[y+1];
        Arrays.fill(count, -1);
    
        ArrayDeque<Integer> q = new ArrayDeque<>();
        count[x] = 0;
        q.offer(x);
        
        int cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            
            if(cur == y)
                break;
                
            if(cur + n <= y && count[cur + n] == -1) {
                count[cur + n] = count[cur] + 1;
                q.offer(cur + n);
            }
            if(cur * 2 <= y && count[cur * 2] == -1) {
                count[cur * 2] = count[cur] + 1;
                q.offer(cur * 2);
            }
            if(cur * 3 <= y && count[cur * 3] == -1) {
                count[cur * 3] = count[cur] + 1;
                q.offer(cur * 3);
            }
        
        }
        
        
        return count[y];
    }
}