import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int len = stones.length;
        int min = Integer.MAX_VALUE;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0; i < k - 1; i++)
            pq.offer(new int[] {stones[i], i});
        
        for(int i = k - 1; i < len; i++) {
            pq.offer(new int[] {stones[i], i});
            
            while(true) {
                int[] top = pq.peek();
                
                if(top[1] > i - k) {
                    min = min < top[0] ? min : top[0];
                    break;
                } else {
                    pq.poll();
                }
            }
            
        }
        
        
        return min;
    }
}