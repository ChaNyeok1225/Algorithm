import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int total = 0;
        int time = 1;
        int idx = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        
        while(!q.isEmpty()) {
            
            if(time >= q.peek()[0]) {
                total -= q.poll()[1];  
            }
            
            if(q.isEmpty() && idx == truck_weights.length)
                break;
            
            if(idx < truck_weights.length) {
                if(total + truck_weights[idx] <= weight) {
                    q.offer(new int[] {time + bridge_length, truck_weights[idx]});
                    total += truck_weights[idx];
                    idx++;
                }
            }
            
            time++;
        }
        
        
        return time;
    }
}