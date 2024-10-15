import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        int n = food_times.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) 
            pq.offer(food_times[i]);
        
        long step = 0, min = 0, round = 0, prev = 0;
        while(!pq.isEmpty()) {
            min = pq.peek();
            round = (min - prev) * pq.size();
            if(k - round < 0)
                break;
            
            prev = pq.poll();
            k -= round; 
        }
        
        if(pq.isEmpty())
            return -1;
        
        k %= pq.size();
        
        for(int i = 0; i < n; i++) {
            if(food_times[i] >= min)
                k--;
            if(k < 0) {
                answer = i + 1;
                break;
            }
        }
  
        return answer;
    }
}